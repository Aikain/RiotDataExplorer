package `in`.aika.riotdataexplorer.api.model.lol.event

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class PauseStart(
    override val timestamp: Long,
    override val type: String,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val realTimestamp: OffsetDateTime,
) : EventsTimeLineDto()
