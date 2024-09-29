package `in`.aika.riotdataexplorer.api.model.lor

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import java.time.OffsetDateTime

data class InfoDto(
    @JsonAlias("game_mode")
    val gameMode: String,

    @JsonAlias("game_type")
    val gameType: String,

    @JsonAlias("game_version")
    val gameVersion: String,

    @JsonAlias("game_format")
    val gameFormat: GameFormat?, // TODO: test case sensitivity

    @JsonAlias("game_start_time_utc")
    val gameStartTimeUtc: OffsetDateTime,

    val players: List<MatchPlayerDto>,

    @JsonAlias("total_turn_count")
    val totalTurnCount: Int,
) : LogIgnoredProperties() {

    enum class GameFormat {
        STANDARD,
        ETERNAL,
    }
}
