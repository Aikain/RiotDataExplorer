package `in`.aika.riotdataexplorer.repository

import `in`.aika.riotdataexplorer.domain.Account
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {

    fun findAllByGameNameStartsWith(q: String, pageable: Pageable): Page<Account>

    fun findByGameNameAndTagLine(gameName: String, tagLine: String): Account?
}
