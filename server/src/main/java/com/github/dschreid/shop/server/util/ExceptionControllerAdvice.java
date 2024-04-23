package com.github.dschreid.shop.server.util;

import com.github.dschreid.shop.server.exception.ThrowableResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.StringJoiner;

/**
 * Augments thrown Exceptions to a more readable way
 *
 * @author dschreid
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        final StringJoiner message = new StringJoiner("\n", "[", "]");
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            message.add("%s %s".formatted(fieldName, errorMessage));
        });
        return new ResponseEntity<>(message.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ThrowableResponseException.class)
    public ResponseEntity<String> handleBadRequestException(ThrowableResponseException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatus());
    }

}
