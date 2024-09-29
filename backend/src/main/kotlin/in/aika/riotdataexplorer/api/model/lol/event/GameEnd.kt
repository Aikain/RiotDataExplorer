package `in`.aika.riotdataexplorer.api.model.lol.event

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class GameEnd(
    override val timestamp: Long,
    override val type: String,

    val gameId: Long,
    val winningTeam: Int,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val realTimestamp: OffsetDateTime,
) : EventsTimeLineDto()
