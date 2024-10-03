package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.domain.current.CurrentLolGame
import `in`.aika.riotdataexplorer.domain.current.CurrentTftGame
import `in`.aika.riotdataexplorer.domain.match.*
import `in`.aika.riotdataexplorer.repository.match.LolMatchRepository
import `in`.aika.riotdataexplorer.repository.match.LorMatchRepository
import `in`.aika.riotdataexplorer.repository.match.MatchRepository
import `in`.aika.riotdataexplorer.repository.match.TftMatchRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class MatchService(
    private val matchRepository: MatchRepository,
    private val lolMatchRepository: LolMatchRepository,
    private val lorMatchRepository: LorMatchRepository,
    private val tftMatchRepository: TftMatchRepository,
) {

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
