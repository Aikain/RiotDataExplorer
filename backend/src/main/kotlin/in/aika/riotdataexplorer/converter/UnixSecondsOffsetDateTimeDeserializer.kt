package `in`.aika.riotdataexplorer.converter

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset


class UnixSecondsOffsetDateTimeDeserializer : StdDeserializer<OffsetDateTime>(OffsetDateTime::class.java) {

    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext?): OffsetDateTime =
        OffsetDateTime.ofInstant(Instant.ofEpochSecond(jp.longValue), ZoneOffset.UTC)
}
