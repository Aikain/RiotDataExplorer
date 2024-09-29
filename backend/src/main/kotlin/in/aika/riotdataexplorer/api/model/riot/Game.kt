package `in`.aika.riotdataexplorer.api.model.riot

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue

enum class Game(private val pathVariable: String? = null) {
    VAL("val"),
    LOR("lor"),

    @JsonEnumDefaultValue
    UNKNOWN;

    fun toPathVariable(): String =
        pathVariable?.takeIf { it.isNotEmpty() } ?: throw IllegalStateException("Invalid enum state")
}
