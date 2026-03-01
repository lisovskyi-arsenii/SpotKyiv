package org.lisovskyi.backend.handler;

import lombok.extern.slf4j.Slf4j;
import org.lisovskyi.backend.exception.ErrorResponse;
import org.lisovskyi.backend.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static final String CUSTOM_UUID_HEADER = "X-Error-ID";


    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFound ex) {
        return buildResponse(ex, HttpStatus.NOT_FOUND, "User not found", null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return buildResponse(ex, HttpStatus.BAD_REQUEST, "Validation failed: " + message, message);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(IllegalArgumentException ex) {
        return buildResponse(ex, HttpStatus.BAD_REQUEST, "Bad Request", null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return buildResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error", null);
    }


    private ResponseEntity<ErrorResponse> buildResponse(Exception ex, HttpStatus status, String logPrefix, String message) {
        String errorId = UUID.randomUUID().toString();

        if (status.is5xxServerError()) {
            log.error("{} [{}]: {}", logPrefix, errorId, ex.getMessage(), ex);
        } else {
            log.warn("{} [{}]: {}", logPrefix, errorId, ex.getMessage(), ex);
        }

        if (message == null) {
            message = status.is5xxServerError() ? "Internal server error" : ex.getMessage();
        }

        return ResponseEntity.status(status)
                .header(CUSTOM_UUID_HEADER, errorId) // для відстеження помилок в логах
                .body(new ErrorResponse(status.value(), message));
    }
}
