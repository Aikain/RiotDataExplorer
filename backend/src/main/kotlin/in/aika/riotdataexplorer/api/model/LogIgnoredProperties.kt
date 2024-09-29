package `in`.aika.riotdataexplorer.api.model

import com.fasterxml.jackson.annotation.JsonAnySetter
import mu.KotlinLogging

abstract class LogIgnoredProperties {

    @JsonAnySetter
    fun logIgnoredProperties(name: String, value: Any) {
        KotlinLogging.logger(this.javaClass.name).warn { "Unknown property: $name" }
    }
}
