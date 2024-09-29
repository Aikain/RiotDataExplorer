package `in`.aika.riotdataexplorer.api.model.lol

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class ChallengeInfo(
    val challengeId: Long,
    val percentile: Double,
    val level: ChallengeLevel,
    val value: Long,
    val playersInLevel: Int,
    val position: Int,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val achievedTime: OffsetDateTime?,
) : LogIgnoredProperties()
