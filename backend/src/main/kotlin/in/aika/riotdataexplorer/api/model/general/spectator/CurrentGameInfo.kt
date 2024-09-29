package `in`.aika.riotdataexplorer.api.model.general.spectator

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class CurrentGameInfo(
    val gameId: Long,
    val platformId: String,
    val gameMode: String,
    val gameType: String,
    val gameQueueConfigId: Long,
    val mapId: Long,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val gameStartTime: OffsetDateTime,

    val participants: List<CurrentGameParticipant>,
    val bannedChampions: List<BannedChampion>,
    val gameLength: Long, // seconds
    val observers: Observer,
) : LogIgnoredProperties()
