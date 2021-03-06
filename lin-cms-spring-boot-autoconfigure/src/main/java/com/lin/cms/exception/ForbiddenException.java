package com.lin.cms.exception;

import com.lin.cms.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpException {

    @Getter
    protected int code = Code.FORBIDDEN.getCode();

    @Getter
    protected int httpCode = HttpStatus.FORBIDDEN.value();

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ForbiddenException(int code) {
        super(Code.FORBIDDEN.getDescription());
        this.code = code;
    }

    public ForbiddenException() {
        super(Code.FORBIDDEN.getDescription());
    }
}
