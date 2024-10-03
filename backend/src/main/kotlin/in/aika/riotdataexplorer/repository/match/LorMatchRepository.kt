package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.LorMatch
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LorMatchRepository : MatchBaseRepository<LorMatch> {

    fun existsByMatchId(matchId: UUID): Boolean
}
