package edu.miu.cs.cs544.raymond.jobsearch.advice;

import edu.miu.cs.cs544.raymond.jobsearch.exception.EmptyInputException;
import edu.miu.cs.cs544.raymond.jobsearch.exception.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {

@ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
    return new ResponseEntity<String>("Empty input field",HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException resourceNotFoundException){
    return new ResponseEntity<String>("Element with the given Id not found",HttpStatus.NOT_FOUND);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException){
    return new ResponseEntity<String>(noSuchElementException.getLocalizedMessage(),HttpStatus.NOT_FOUND);
}
@ExceptionHandler(EmptyResultDataAccessException.class)
public ResponseEntity<String> handleEmptyResultDataAccess(EmptyResultDataAccessException emptyResultDataAccessException){
    return new ResponseEntity<String>(emptyResultDataAccessException.getLocalizedMessage(),HttpStatus.NOT_FOUND);
}

@ExceptionHandler(HttpMessageNotWritableException.class)
public ResponseEntity<String> handleHttpMessageNotWritable(HttpMessageNotWritableException httpMessageNotWritableException){
    return new ResponseEntity<String>("Element with the given Id not found",HttpStatus.NOT_FOUND);
}
@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
    return new ResponseEntity<Object>("Please change your http method type",HttpStatus.NOT_FOUND);
}
}
