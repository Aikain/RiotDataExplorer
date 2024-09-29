package `in`.aika.riotdataexplorer.api.model.lol

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class ChampionMasteryDto(
    val puuid: String, // encrypted
    val championId: Long,
    val championLevel: Int,
    val championPoints: Int,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val lastPlayTime: OffsetDateTime,

    val championPointsSinceLastLevel: Long,
    val championPointsUntilNextLevel: Long,
    val markRequiredForNextLevel: Int,
    val tokensEarned: Int,
    val championSeasonMilestone: Int,
    val nextSeasonMilestone: NextSeasonMilestonesDto,

    // Old ?
    val milestoneGrades: List<String> = listOf(),
    val chestGranted: Boolean,
) : LogIgnoredProperties()
