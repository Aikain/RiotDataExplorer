package `in`.aika.riotdataexplorer.api.model.general.summoner

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class SummonerDTO(
    val puuid: String,
    val accountId: String,
    val id: String,
    val summonerLevel: Long,
    val profileIconId: Int,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val revisionDate: OffsetDateTime,
) : LogIgnoredProperties()
