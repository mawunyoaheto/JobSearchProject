package edu.miu.cs.cs544.raymond.jobsearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private HttpStatus httpStatus;
    public ResourceNotFoundException(HttpStatus httpStatus, String errorMessage) {
        super(errorMessage);
        this.httpStatus=httpStatus;
    }
}
