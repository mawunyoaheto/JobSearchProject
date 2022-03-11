package edu.miu.cs.cs544.raymond.jobsearch.exception;

import org.springframework.stereotype.Component;

@Component
public class ResourceNotFoundException extends RuntimeException{
    private  static final long serialVersionUID = 1L;

    private String errorCode;
    private String errorMessage;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public  static long getSerialVersionUID(){
        return serialVersionUID;
    }
}
