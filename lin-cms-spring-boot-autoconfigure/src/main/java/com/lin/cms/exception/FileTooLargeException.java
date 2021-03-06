package com.lin.cms.exception;

import com.lin.cms.beans.Code;
import lombok.Getter;
import org.springframework.http.HttpStatus;


public class FileTooLargeException extends HttpException {

    @Getter
    protected int code = Code.FILE_TOO_LARGE.getCode();

    @Getter
    protected int httpCode = HttpStatus.PAYLOAD_TOO_LARGE.value();


    public FileTooLargeException(String message) {
        super(message);
    }

    public FileTooLargeException() {
        super(Code.FILE_TOO_LARGE.getDescription());
    }

    public FileTooLargeException(int code) {
        super(Code.FILE_TOO_LARGE.getDescription());
        this.code = code;
    }

    public FileTooLargeException(String message, int code) {
        super(message);
        this.code = code;
    }
}
