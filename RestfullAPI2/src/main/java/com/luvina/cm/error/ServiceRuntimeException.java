package com.luvina.cm.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

@Getter
public class ServiceRuntimeException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String errorCode;

    public ServiceRuntimeException(HttpStatus httpStatus,
                                   String errorCode,
                                   String errorMessage) {
        super(errorMessage);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

}
