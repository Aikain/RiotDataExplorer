package `in`.aika.riotdataexplorer.domain.current

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import `in`.aika.riotdataexplorer.api.model.data.riot.GameMap
import `in`.aika.riotdataexplorer.api.model.data.riot.GameMode
import `in`.aika.riotdataexplorer.api.model.data.riot.GameType
import java.time.OffsetDateTime

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
)
@JsonSubTypes(
    JsonSubTypes.Type(value = CurrentLolGame::class, name = "LOL"),
    JsonSubTypes.Type(value = CurrentTftGame::class, name = "TFT"),
)
sealed class CurrentGame<Queue, Participant> {
    abstract val gameId: Long
    abstract val platformId: String
    abstract val gameMode: GameMode
    abstract val gameType: GameType
    abstract val queue: Queue
    abstract val map: GameMap
    abstract val gameStartTime: OffsetDateTime
    abstract val participants: List<Participant>
}
