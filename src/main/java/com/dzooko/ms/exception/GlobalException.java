package com.dzooko.ms.exception;

import com.dzooko.ms.exception.error.ErrorDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException  extends ResponseEntityExceptionHandler{

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);


    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleStudentNotFoundException(Exception e, WebRequest request){
        ErrorDetail errorDetail = new ErrorDetail(
                LocalDateTime.now(), HttpStatus.NOT_FOUND,e.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
    }





}

