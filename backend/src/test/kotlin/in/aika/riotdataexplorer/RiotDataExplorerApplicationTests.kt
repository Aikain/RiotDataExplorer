package `in`.aika.riotdataexplorer

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.TestPropertySource

@TestPropertySource(properties = arrayOf(
    "RIOT_API_KEY = invalid-api-key",
))
@SpringBootTest
class RiotDataExplorerApplicationTests {

    @Test
    fun contextLoads() {}
}
