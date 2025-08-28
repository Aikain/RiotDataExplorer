package `in`.aika.riotdataexplorer.api.model.riot

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty
import `in`.aika.riotdataexplorer.api.routing.LorRegion

enum class ActiveShard {
    @JsonProperty("americas")
    AMERICAS,

    @JsonProperty("apac")
    APAC,

    @JsonProperty("asia")
    ASIA,

    @JsonProperty("europe")
    EUROPE,

    @JsonProperty("sea")
    SEA,

    @JsonEnumDefaultValue
    UNKNOWN,
    ;

    fun toLorRegion(): LorRegion? = when (this) {
        AMERICAS -> LorRegion.AMERICAS
        APAC -> LorRegion.APAC
        ASIA -> LorRegion.ASIA
        EUROPE -> LorRegion.EUROPE
        SEA -> LorRegion.SEA
        UNKNOWN -> null
    }
}
