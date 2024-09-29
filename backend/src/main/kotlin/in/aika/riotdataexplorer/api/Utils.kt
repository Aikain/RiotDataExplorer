package `in`.aika.riotdataexplorer.api

import com.fasterxml.jackson.databind.MapperFeature
import mu.KotlinLogging
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpResponse
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

private val logger = KotlinLogging.logger {}

class Utils {
    companion object {
        fun <T> createApiClient(host: String, apiKey: String, serviceType: Class<T>): T = HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(RestClient.builder()
                .baseUrl("https://${host}")
                .defaultHeader("X-Riot-Token", apiKey)
                .messageConverters(this::initMessageConverters)
                .requestInterceptor(this::logRequest)
                .build()))
            .build()
            .createClient(serviceType)

        private fun logRequest(
            request: HttpRequest,
            body: ByteArray,
            execution: ClientHttpRequestExecution
        ): ClientHttpResponse {
            logger.debug { "${request.method} ${request.uri}" }
            return execution.execute(request, body)
        }

        private fun initMessageConverters(messageConverters: MutableList<HttpMessageConverter<*>?>) {
            messageConverters.forEach {
                if (it is MappingJackson2HttpMessageConverter)
                    it.objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
            }
        }
    }
}
