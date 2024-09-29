package `in`.aika.riotdataexplorer.api

import com.fasterxml.jackson.databind.MapperFeature
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory


class Utils {
    companion object {
        fun <T> createApiClient(host: String, apiKey: String, serviceType: Class<T>): T = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(RestClient.builder()
                .baseUrl("https://${host}")
                .defaultHeader("X-Riot-Token", apiKey)
                .messageConverters(this::initMessageConverters)
                .build()))
            .build()
            .createClient(serviceType)

        fun initMessageConverters(messageConverters: MutableList<HttpMessageConverter<*>?>) {
            messageConverters.forEach {
                if (it is MappingJackson2HttpMessageConverter)
                    it.objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            }
        }
    }
}
