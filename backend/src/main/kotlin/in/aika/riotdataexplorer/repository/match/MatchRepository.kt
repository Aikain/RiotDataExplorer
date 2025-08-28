package `in`.aika.riotdataexplorer.repository.match

import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.domain.match.Match
import `in`.aika.riotdataexplorer.domain.match.Participant
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface MatchRepository : MatchBaseRepository<Match<Participant>> {

    @Query("""
        SELECT m FROM Match m
        LEFT JOIN TREAT (m AS LolMatch).participants p
        WHERE p.account = :account
    """)
    fun findAllByAccount(@Param("account") account: Account, pageable: Pageable): Page<Match<*>>
}
