package `in`.aika.riotdataexplorer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RiotDataExplorerApplication

fun main(args: Array<String>) {
    runApplication<RiotDataExplorerApplication>(*args)
}
