package `in`.aika.riotdataexplorer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class RiotDataExplorerApplication

fun main(args: Array<String>) {
    runApplication<RiotDataExplorerApplication>(*args)
}
