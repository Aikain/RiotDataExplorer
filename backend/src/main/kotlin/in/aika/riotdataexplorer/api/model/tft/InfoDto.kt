package `in`.aika.riotdataexplorer.api.model.tft

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class InfoDto(
    val gameId: Long,

    @JsonAlias("queue_id")
    val queueId: Int,
    val mapId: Int,

    @JsonAlias("game_variation")
    val gameVariation: String?,

    @JsonAlias("game_version")
    val gameVersion: String,

    @JsonAlias("tft_set_number")
    val tftSetNumber: Int,

    @JsonAlias("tft_set_core_name")
    val tftSetCoreName: String,

    @JsonAlias("tft_game_type")
    val tftGameType: String,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val gameCreation: OffsetDateTime,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    @JsonAlias("game_datetime")
    val gameDatetime: OffsetDateTime,

    @JsonAlias("game_length")
    val gameLength: Float, // seconds
    val endOfGameResult: String,
    val participants: List<ParticipantDto>,
) : LogIgnoredProperties()
