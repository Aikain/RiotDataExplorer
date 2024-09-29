package `in`.aika.riotdataexplorer.api.model.riot

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue
import com.fasterxml.jackson.annotation.JsonProperty

enum class ActiveShard {
    @JsonProperty("americas")
    AMERICAS,

    @JsonProperty("asia")
    ASIA,

    @JsonProperty("europe")
    EUROPE,

    @JsonProperty("sea")
    SEA,

    @JsonEnumDefaultValue
    UNKNOWN,
}
