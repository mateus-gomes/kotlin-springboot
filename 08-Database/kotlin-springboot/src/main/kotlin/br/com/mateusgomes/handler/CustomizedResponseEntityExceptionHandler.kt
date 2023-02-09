package br.com.mateusgomes.handler

import br.com.mateusgomes.exception.ExceptionResponse
import br.com.mateusgomes.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import java.util.*

@RestController
@ControllerAdvice
class CustomizedResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(exception: Exception, request: WebRequest): ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            message = exception.message,
            details = request.getDescription(false)
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundExceptions(exception: Exception, request: WebRequest): ResponseEntity<ExceptionResponse>{
        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            message = exception.message,
            details = request.getDescription(false)
        )

        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }
}