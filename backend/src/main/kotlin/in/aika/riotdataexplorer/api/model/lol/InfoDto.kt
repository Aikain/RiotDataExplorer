package `in`.aika.riotdataexplorer.api.model.lol

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties
import `in`.aika.riotdataexplorer.converter.UnixMilliSecondsOffsetDateTimeDeserializer
import java.time.OffsetDateTime

data class InfoDto(
    val gameId: Long,
    val platformId: String,
    val queueId: Int,
    val mapId: Int,
    val gameVersion: String,
    val gameMode: String,
    val gameName: String,
    val gameType: String,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val gameCreation: OffsetDateTime,

    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val gameStartTimestamp: OffsetDateTime,

    // Unix timestamp for when match ends on the game server. This timestamp can occasionally be significantly longer
    // than when the match "ends". The most reliable way of determining the timestamp for the end of the match would be
    // to add the max time played of any participant to the gameStartTimestamp. This field was added to match-v5 in
    // patch 11.20 on Oct 5th, 2021.
    @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
    val gameEndTimestamp: OffsetDateTime,

    // Prior to patch 11.20, this field returns the game length in milliseconds calculated from gameEndTimestamp -
    // gameStartTimestamp. Post patch 11.20, this field returns the max timePlayed of any participant in the game in
    // seconds, which makes the behavior of this field consistent with that of match-v4. The best way to handling the
    // change in this field is to treat the value as milliseconds if the gameEndTimestamp field isn't in the response
    // and to treat the value as seconds if gameEndTimestamp is in the response.
    val gameDuration: Long,
    val endOfGameResult: String?,
    val participants: List<ParticipantDto>,
    val teams: List<MatchTeamDto>,
    val tournamentCode: String,
) : LogIgnoredProperties()
