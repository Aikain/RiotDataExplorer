package `in`.aika.riotdataexplorer.config

import org.springframework.http.HttpStatus
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.net.URI

@ControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun ErrorResponse(ex: Exception): ErrorResponse {
        logger.warn("Unknown exception", ex)
        return ErrorResponse
            .builder(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Unknown exception. Please see server logs for more details.")
            .type(URI.create("https://riot-data-explorer.aika.in/exceptions/UnknownException"))
            .build()
    }
}
