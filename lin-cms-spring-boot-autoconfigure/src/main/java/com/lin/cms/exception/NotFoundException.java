package com.lin.cms.exception;

import com.lin.cms.beans.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {

    @Getter
    private int errorCode = ErrorCode.NOT_FOUND.getCode();

    @Getter
    private int httpCode = HttpStatus.NOT_FOUND.value();

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND.getDescription());
    }
}