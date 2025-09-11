package com.crudoperation.CrudOperation.globalexception;

import com.crudoperation.CrudOperation.customexception.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class StudentException {

    // Handle StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
        log.info("studentnotfound");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Handle InternalServerException
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> InternalServerException(Exception ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle invalid endpoint (404)

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNoHandlerFound(NoHandlerFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Invalid API endpoint: " + ex.getRequestURL());
    }

    // Handle wrong method (405)

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body("HTTP method not supported: " + ex.getMethod());
    }
}
