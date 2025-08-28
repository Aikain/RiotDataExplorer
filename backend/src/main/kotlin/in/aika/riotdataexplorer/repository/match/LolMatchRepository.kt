package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.match.LolMatch
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LolMatchRepository : MatchBaseRepository<LolMatch> {

    fun existsByMatchId(matchId: String): Boolean

    @Query("""
        SELECT m.matchId FROM LolMatch m
        WHERE m.matchId IN :ids
    """)
    fun findIdsByIds(ids: List<String>): Set<String>
}
