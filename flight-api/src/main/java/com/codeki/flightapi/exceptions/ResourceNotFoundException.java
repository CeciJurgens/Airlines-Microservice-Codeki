package com.codeki.flightapi.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class ResourceNotFoundException extends IllegalArgumentException{
    private String resourceName;
    private String fieldName;
    private Long value;

    public ResourceNotFoundException(String resourceName, String fieldName, Long value) {
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
