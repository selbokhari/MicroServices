package com.sohaib.security.conf;

import com.sohaib.exceptions.exception.BusinessException;
import com.sohaib.exceptions.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(BusinessException ex) {
        return ResponseEntity.status(ex.getCode())
                .body(ErrorDto.builder().message(ex.getMessage()).build());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleOtherExceptions(BusinessException ex) {
        return ResponseEntity.status(ex.getCode())
                .body(ErrorDto.builder().message("Une erreur inattendue est survenue !").build());
    }

}
