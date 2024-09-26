package `in`.aika.riotdataexplorer.config

import `in`.aika.riotdataexplorer.api.RiotAccountApi
import `in`.aika.riotdataexplorer.api.RiotSummonerApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class RiotClientConfig(
    @Value("\${RIOT_API_KEY}") val riotApiKey: String
) {

    fun factory(baseUrl: String) = HttpServiceProxyFactory
        .builderFor(RestClientAdapter.create(RestClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader("X-Riot-Token", riotApiKey)
            .build()))
        .build()

    fun routingBaseClient() = factory("https://europe.api.riotgames.com")
    fun regionBaseClient() = factory("https://eun1.api.riotgames.com")

    @Bean
    fun riotAccountApi(): RiotAccountApi = routingBaseClient().createClient(RiotAccountApi::class.java);

    @Bean
    fun riotSummonerApi(): RiotSummonerApi = regionBaseClient().createClient(RiotSummonerApi::class.java);
}
