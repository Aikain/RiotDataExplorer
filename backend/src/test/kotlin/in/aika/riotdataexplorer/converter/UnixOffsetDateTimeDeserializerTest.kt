package `in`.aika.riotdataexplorer.converter

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Assertions.assertNotNull
import java.time.OffsetDateTime
import java.time.ZoneOffset
import kotlin.test.Test

val mapper = jacksonObjectMapper()

class UnixOffsetDateTimeDeserializerTest {

    data class MilliSeconds(
        @JsonDeserialize(using = UnixMilliSecondsOffsetDateTimeDeserializer::class)
        val time: OffsetDateTime,
    )

    data class Seconds(
        @JsonDeserialize(using = UnixSecondsOffsetDateTimeDeserializer::class)
        val time: OffsetDateTime,
    )

    @Test
    fun testMilliSecondsDeserializer() {
        val json = """{ "time": 1727500167596 }"""
        val a: MilliSeconds = mapper.readValue(json)

        assertNotNull(a)
        kotlin.test.assertEquals(OffsetDateTime.of(2024, 9, 28, 5, 9, 27, 596000000, ZoneOffset.UTC), a.time)
    }

    @Test
    fun testSecondsDeserializer() {
        val json = """{ "time": 1727500167 }"""
        val a: Seconds = mapper.readValue(json)

        assertNotNull(a)
        kotlin.test.assertEquals(OffsetDateTime.of(2024, 9, 28, 5, 9, 27, 0, ZoneOffset.UTC), a.time)
    }
}
