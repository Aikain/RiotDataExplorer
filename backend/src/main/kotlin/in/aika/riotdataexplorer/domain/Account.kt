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

    @JsonView(Views.AccountGet::class)
    @OneToOne(cascade = [CascadeType.DETACH], optional = true)
    @JoinColumn(name = "summoner_id")
    var summoner: Summoner?,

    @Enumerated(EnumType.STRING)
    val activeShard: ActiveShard?,
    val updated: OffsetDateTime = OffsetDateTime.now(ZoneOffset.UTC),
) {

    constructor(account: AccountDto, summoner: Summoner?, activeShard: ActiveShard?) : this(
        account.puuid,
        account.gameName,
        account.tagLine,
        summoner,
        activeShard,
        OffsetDateTime.now(ZoneOffset.UTC),
    )
}
