package `in`.aika.riotdataexplorer.domain

import com.fasterxml.jackson.annotation.JsonView
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.data.ProfileIcon
import `in`.aika.riotdataexplorer.api.model.general.summoner.SummonerDTO
import `in`.aika.riotdataexplorer.api.routing.LolPlatform
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Entity
class Summoner(
    @Id
    val id: String,

    @Enumerated(EnumType.STRING)
    val platform: LolPlatform,
    val accountId: String,

    @JsonView(Views.SummonerList::class)
    val level: Long,
    val profileIconId: Int,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val revisionDate: OffsetDateTime,
    val updated: OffsetDateTime,
) {
    @Transient
    @JsonView(Views.SummonerList::class)
    var profileIcon: ProfileIcon? = null

    constructor(summoner: SummonerDTO, platform: LolPlatform) : this(
        summoner.id,
        platform,
        summoner.accountId,
        summoner.summonerLevel,
        summoner.profileIconId,
        summoner.revisionDate,
        OffsetDateTime.now(ZoneOffset.UTC),
    )
}
