package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String message;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException(String message, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", message, fieldName, fieldValue));
        this.message = message;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}