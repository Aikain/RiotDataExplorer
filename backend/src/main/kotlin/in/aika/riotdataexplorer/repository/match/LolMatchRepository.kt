package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.LolMatch
import org.springframework.stereotype.Repository

@Repository
interface LolMatchRepository : MatchBaseRepository<LolMatch> {

    fun existsByMatchId(matchId: String): Boolean
}
