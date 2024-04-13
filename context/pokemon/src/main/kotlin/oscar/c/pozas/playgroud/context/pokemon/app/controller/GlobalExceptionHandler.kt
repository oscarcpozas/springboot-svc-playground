package oscar.c.pozas.playgroud.context.pokemon.app.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import oscar.c.pozas.playground.kernel.logging.Logger
import oscar.c.pozas.playgroud.context.pokemon.app.controller.viewmodel.ApiErrorViewModel

@ControllerAdvice
class GlobalExceptionHandler(private val logger: Logger) {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGenericException(exception: Exception): ApiErrorViewModel {
        logger.error(message = "Unexpected error", exception)
        return ApiErrorViewModel("Unexpected error")
    }
}
