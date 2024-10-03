package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.lol.LolApiClient
import `in`.aika.riotdataexplorer.api.client.tft.TftApiClient
import `in`.aika.riotdataexplorer.api.model.general.spectator.CurrentGameInfo
import `in`.aika.riotdataexplorer.api.model.general.spectator.CurrentGameParticipant
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.current.*
import org.springframework.cache.annotation.Cacheable
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound

@Service
class CurrentGameService(
    private val lolApiClient: LolApiClient,
    private val tftApiClient: TftApiClient,
    private val dataDragonService: DataDragonService,
    @Lazy private val accountService: AccountService,
) {

    @Cacheable("currentGames")
    fun getCurrentGame(account: Account): CurrentGame<*, *>? {
        account.summoner?.let {
            try {
                return currentGameToLolGame(lolApiClient.spectatorActiveGameByPuuid(it.platform, account.puuid))
            } catch (ignored: NotFound) {}
            try {
                return currentGameToTftGame(tftApiClient.spectatorActiveGameByPuuid(it.platform.toTftPlatform(), account.puuid))
            } catch (ignored: NotFound) {}
        }
        return null
    }

    private fun currentGameToLolGame(currentGame: CurrentGameInfo): CurrentLolGame = CurrentLolGame(
        currentGame.gameId,
        currentGame.platformId,
        dataDragonService.getGameMode(currentGame.gameMode),
        dataDragonService.getGameType(currentGame.gameType),
        dataDragonService.getQueue(currentGame.gameQueueConfigId),
        dataDragonService.getGameMap(currentGame.mapId),
        currentGame.gameStartTime,
        currentGame.participants.map(::participantToLolParticipant),
        currentGame.bannedChampions.map { BannedChampion(it.pickTurn, dataDragonService.getChampion(it.championId), it.teamId) },
    )

    private fun currentGameToTftGame(currentGame: CurrentGameInfo): CurrentTftGame = CurrentTftGame(
        currentGame.gameId,
        currentGame.platformId,
        dataDragonService.getGameMode(currentGame.gameMode),
        dataDragonService.getGameType(currentGame.gameType),
        dataDragonService.getTftQueue(currentGame.gameQueueConfigId),
        dataDragonService.getGameMap(currentGame.mapId),
        currentGame.gameStartTime,
        currentGame.participants.map(::participantToTftParticipant),
    )

    private fun participantToLolParticipant(participant: CurrentGameParticipant): LolParticipant = LolParticipant(
        dataDragonService.fillStaticData(accountService.getAccountByPuuid(participant.puuid, participant.riotId)),
        participant.bot,
        participant.teamId,
        dataDragonService.getChampion(participant.championId),
        dataDragonService.getSummonerSpell(participant.spell1Id),
        dataDragonService.getSummonerSpell(participant.spell2Id),
        participant.perks!!.let {
            Perks(
                dataDragonService.getRunes(it.perkIds),
                dataDragonService.getRuneTree(it.perkStyle),
                dataDragonService.getRuneTree(it.perkSubStyle),
            )
        },
    )

    private fun participantToTftParticipant(participant: CurrentGameParticipant): TftParticipant = TftParticipant(
        dataDragonService.fillStaticData(accountService.getAccountByPuuid(participant.puuid, participant.riotId)),
        participant.bot,
        participant.teamId,
    )
}
