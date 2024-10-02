package `in`.aika.riotdataexplorer.domain.current

import com.fasterxml.jackson.annotation.JsonView
import `in`.aika.riotdataexplorer.api.model.data.riot.GameMap
import `in`.aika.riotdataexplorer.api.model.data.riot.GameMode
import `in`.aika.riotdataexplorer.api.model.data.riot.GameType
import `in`.aika.riotdataexplorer.api.model.data.riot.Queue
import `in`.aika.riotdataexplorer.domain.Views
import java.time.OffsetDateTime

@JsonView(Views.CurrentGameGet::class)
data class CurrentTftGame(
    override val gameId: Long,
    override val platformId: String,
    override val gameMode: GameMode,
    override val gameType: GameType,
    override val queue: Queue,
    override val map: GameMap,
    override val gameStartTime: OffsetDateTime,
    override val participants: List<TftParticipant>,
) : CurrentGame<Queue, TftParticipant>()
