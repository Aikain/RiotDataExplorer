package `in`.aika.riotdataexplorer.domain

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.riot.AccountDto
import `in`.aika.riotdataexplorer.api.model.riot.ActiveShard
import jakarta.persistence.*
import org.springframework.data.domain.Persistable
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Entity
class Account(
    @Id
    val puuid: String,

    @JsonView(Views.AccountList::class)
    @Column(length = 16)
    val gameName: String,

    @JsonView(Views.AccountList::class)
    @Column(length = 5)
    val tagLine: String,

    @JsonView(Views.AccountList::class)
    @OneToOne(cascade = [CascadeType.DETACH], optional = true)
    @JoinColumn(name = "summoner_id")
    var summoner: Summoner?,

    @Enumerated(EnumType.STRING)
    val activeShard: ActiveShard?,
    val updated: OffsetDateTime = OffsetDateTime.now(ZoneOffset.UTC),
) : Persistable<String> {

    constructor(account: AccountDto, summoner: Summoner?, activeShard: ActiveShard?) : this(
        account.puuid,
        account.gameName,
        account.tagLine,
        summoner,
        activeShard,
        OffsetDateTime.now(ZoneOffset.UTC),
    )

    override fun getId(): String = puuid
    override fun isNew(): Boolean = false
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Account
        return puuid == other.puuid
    }
    override fun hashCode(): Int = puuid.hashCode()
}
