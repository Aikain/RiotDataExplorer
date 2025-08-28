package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.TftMatch
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TftMatchRepository : MatchBaseRepository<TftMatch> {

    fun existsByMatchId(matchId: String): Boolean

    @Query("""
        SELECT m.matchId FROM TftMatch m
        WHERE m.matchId IN :ids
    """)
    fun findIdsByIds(ids: List<String>): Set<String>
}
