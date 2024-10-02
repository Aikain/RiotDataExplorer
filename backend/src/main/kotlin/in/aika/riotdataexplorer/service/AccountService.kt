package `in`.aika.riotdataexplorer.service

import `in`.aika.riotdataexplorer.api.client.riot.RiotApiClient
import `in`.aika.riotdataexplorer.api.model.riot.ActiveShard
import `in`.aika.riotdataexplorer.api.model.riot.Game
import `in`.aika.riotdataexplorer.domain.Account
import `in`.aika.riotdataexplorer.repository.AccountRepository
import org.springframework.context.annotation.Lazy
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import org.springframework.web.server.ResponseStatusException

@Service
class AccountService(
    private val riotApiClient: RiotApiClient,
    private val accountRepository: AccountRepository,
    private val summonerService: SummonerService,
) {

    fun findByQ(q: String?, pageable: Pageable): Page<Account> = q
        ?.let { accountRepository.findAllByGameNameStartsWith(q, pageable) }
        ?: accountRepository.findAll(pageable)

    fun getAccountByPuuid(puuid: String, riotId: String): Account =
        getAccount(
            riotId.substring(0, riotId.indexOf("#")),
            riotId.substring(riotId.indexOf("#") + 1),
            puuid,
        )

    fun getAccount(gameName: String, tagLine: String, puuid: String? = null): Account =
        accountRepository.findByGameNameAndTagLine(gameName, tagLine)
            ?.let {
                if (it.summoner == null) {
                    it.summoner = summonerService.findSummoner(it.puuid, it.tagLine)
                    if (it.summoner != null) return accountRepository.save(it)
                }
                return it
            }
            ?: createAccount(gameName, tagLine, puuid)

    private fun createAccount(gameName: String, tagLine: String, puuid: String?): Account {
        try {
            puuid?.let {
                return accountRepository.save(Account(it, gameName, tagLine, summonerService.findSummoner(puuid, tagLine), findActiveShard(puuid)))
            }
            val account = riotApiClient.accountByRiotId(gameName, tagLine)
            return accountRepository.save(Account(account, summonerService.findSummoner(account.puuid, account.tagLine), findActiveShard(account.puuid)))
        } catch (ex: NotFound) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found with given game name and tag line")
        }
    }

    private fun findActiveShard(puuid: String): ActiveShard? {
        try {
            return riotApiClient.activeShardsByGameAndPuuid(Game.LOR, puuid).activeShard
        } catch (ignored: NotFound) {}
        return null
    }
}
