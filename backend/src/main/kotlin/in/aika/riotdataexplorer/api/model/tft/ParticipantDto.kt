package `in`.aika.riotdataexplorer.api.model.tft

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class ParticipantDto(
    val puuid: String, // encrypted
    val companion: CompanionDto,

    val placement: Int,
    val level: Int, // little legend level

    @JsonAlias("last_round")
    val lastRound: Int,

    @JsonAlias("gold_left")
    val goldLeft: Int,

    @JsonAlias("time_eliminated")
    val timeEliminated: Float, // seconds

    @JsonAlias("players_eliminated")
    val playersEliminated: Int,

    @JsonAlias("total_damage_to_players")
    val totalDamageToPlayers: Int,

    val traits: List<TraitDto>,
    val units: List<UnitDto>,
    val augments: List<String>,
    val missions: Map<String, Int>, // TODO: MissionsDto?
) : LogIgnoredProperties()
