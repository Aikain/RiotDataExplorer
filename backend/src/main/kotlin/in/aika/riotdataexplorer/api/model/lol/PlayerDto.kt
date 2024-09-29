package `in`.aika.riotdataexplorer.api.model.lol

import `in`.aika.riotdataexplorer.api.model.LogIgnoredProperties

data class PlayerDto(
    val summonerId: String,
    val teamId: String,
    val position: Position,
    val role: Role,
) : LogIgnoredProperties() {
    enum class Position {
        UNSELECTED,
        FILL,
        TOP,
        JUNGLE,
        MIDDLE,
        BOTTOM,
        UTILITY,
    }

    enum class Role {
        CAPTAIN,
        MEMBER,
    }
}
