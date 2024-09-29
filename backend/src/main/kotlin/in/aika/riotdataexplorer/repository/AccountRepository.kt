package `in`.aika.riotdataexplorer.repository

import `in`.aika.riotdataexplorer.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {

    fun findByGameNameAndTagLine(gameName: String, tagLine: String): Account?
}
