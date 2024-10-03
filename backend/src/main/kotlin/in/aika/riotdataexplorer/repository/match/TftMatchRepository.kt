package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.TftMatch
import org.springframework.stereotype.Repository

@Repository
interface TftMatchRepository : MatchBaseRepository<TftMatch> {

    fun existsByMatchId(matchId: String): Boolean
}
