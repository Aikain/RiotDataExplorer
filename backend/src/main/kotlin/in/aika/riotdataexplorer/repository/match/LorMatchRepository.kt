package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.LorMatch
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LorMatchRepository : MatchBaseRepository<LorMatch> {

    fun existsByMatchId(matchId: UUID): Boolean

    @Query("""
        SELECT m.matchId FROM LorMatch m
        WHERE m.matchId IN :ids
    """)
    fun findIdsByIds(ids: List<UUID>): Set<UUID>
}
