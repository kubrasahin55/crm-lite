package com.etiya.crmlite.core.utilities.exceptions;
import com.etiya.crmlite.core.utilities.results.ErrorDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors, "VALIDATION.EXCEPTION");
        return errorDataResult;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleBusinessException(BusinessException businessException) {
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(),
                "BUSINESS.EXCEPTION");
        return errorDataResult;
    }
}
