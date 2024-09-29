package `in`.aika.riotdataexplorer.api.model.lor

import com.fasterxml.jackson.annotation.JsonAlias
import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class MatchPlayerDto(
    val puuid: String,

    @JsonAlias("deck_id")
    val deckId: String,

    @JsonAlias("deck_code")
    val deckCode: String,
    val factions: List<String>,

    @JsonAlias("game_outcome")
    val gameOutcome: String,

    @JsonAlias("order_of_play")
    val orderOfPlay: Int,
) : LogIgnoredProperties()
