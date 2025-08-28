package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.lol.LolApiClient
import `in`.aika.riotdataexplorer.api.client.lor.LorApiClient
import `in`.aika.riotdataexplorer.api.client.tft.TftApiClient
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.current.CurrentLolGame
import `in`.aika.riotdataexplorer.domain.current.CurrentTftGame
import `in`.aika.riotdataexplorer.domain.match.*
import `in`.aika.riotdataexplorer.repository.match.LolMatchRepository
import `in`.aika.riotdataexplorer.repository.match.LorMatchRepository
import `in`.aika.riotdataexplorer.repository.match.MatchRepository
import `in`.aika.riotdataexplorer.repository.match.TftMatchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class MatchService(
    private val lolApiClient: LolApiClient,
    private val lorApiClient: LorApiClient,
    private val tftApiClient: TftApiClient,
    private val matchRepository: MatchRepository,
    private val lolMatchRepository: LolMatchRepository,
    private val lorMatchRepository: LorMatchRepository,
    private val tftMatchRepository: TftMatchRepository,
) {

    fun getMatches(account: Account, pageable: Pageable): Page<Match<*>> {
        updateMatches(account)
        return matchRepository.findAllByAccount(account, pageable)
    }

    fun updateMatches(account: Account) = runBlocking {
        awaitAll(
            async(Dispatchers.IO) {
                account.summoner?.let {
                    val matches = lolApiClient.matchesByPuuid(it.platform, account.puuid)
                    if (matches.isEmpty()) return@let
                    val tmp = lolMatchRepository.findIdsByIds(matches)
                    lolMatchRepository.saveAll(matches
                        .filter { !tmp.contains(it) }
                        .map {
                            LolMatch(it, MatchStatus.AVAILABLE).apply {
                                participants.add(LolParticipant(this, account))
                            }
                        })
                }
            },
            async(Dispatchers.IO) {
                account.activeShard?.toLorRegion()?.let {
                    val matches = lorApiClient.matchesByPuuid(it, account.puuid)
                    if (matches.isEmpty()) return@let
                    val tmp = lorMatchRepository.findIdsByIds(matches)
                    lorMatchRepository.saveAll(matches
                        .filter { !tmp.contains(it) }
                        .map {
                            LorMatch(it, MatchStatus.AVAILABLE).apply {
                                participants.add(LorParticipant(this, account))
                            }
                        })
                }

            },
            async(Dispatchers.IO) {
                account.summoner?.let {
                    val matches = tftApiClient.matchesByPuuid(it.platform.toTftPlatform(), account.puuid)
                    if (matches.isEmpty()) return@let
                    val tmp = tftMatchRepository.findIdsByIds(matches)
                    tftMatchRepository.saveAll(matches
                        .filter { !tmp.contains(it) }
                        .map {
                            TftMatch(it, MatchStatus.AVAILABLE).apply {
                                participants.add(TftParticipant(this, account))
                            }
                        })
                }
            },
        )
    }

    fun findMatch(matchId: String): Match<*>? {
        // TODO: tarkistan ensin db, sitten vasta apista! ei haeta suoraan ID:llä, jos ei tiedetä sitä olevan!
        return null
    }

    @Async
    fun create(currentGame: CurrentLolGame) {
        val matchId = "${currentGame.platformId}_${currentGame.gameId}"
        if (lolMatchRepository.existsByMatchId(matchId)) return

        val match = LolMatch(matchId, MatchStatus.IN_PROGRESS)
        match.participants.addAll(currentGame.participants.map { LolParticipant(match, it.account) })
        lolMatchRepository.save(match)
    }

    @Async
    fun create(currentGame: CurrentTftGame) {
        val matchId = "${currentGame.platformId}_${currentGame.gameId}"
        if (tftMatchRepository.existsByMatchId(matchId)) return

        val match = TftMatch(matchId, MatchStatus.IN_PROGRESS)
        match.participants.addAll(currentGame.participants.map { TftParticipant(match, it.account) })
        tftMatchRepository.save(match)
    }
}
