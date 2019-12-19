package com.lin.cms.demo.common.exception;

import com.google.common.base.Strings;
import com.lin.cms.beans.ErrorCode;
import com.lin.cms.demo.common.configure.ErrorCodeConfig;
import com.lin.cms.demo.vo.CommonResult;
import com.lin.cms.exception.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Order
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @Value("${spring.servlet.multipart.max-file-size:20M}")
    private String maxFileSize;

    /**
     * HttpException
     */
    @ExceptionHandler({HttpException.class})
    public CommonResult processException(HttpException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        int errorCode = exception.getErrorCode();
        result.setErrorCode(errorCode);
        response.setStatus(exception.getHttpCode());
        String errorMessage = ErrorCodeConfig.getErrorMessage(errorCode);
        if (Strings.isNullOrEmpty(errorMessage)) {
            result.setMsg(exception.getMessage());
        } else {
            result.setMsg(errorMessage);
        }
        return result;
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public CommonResult processException(ConstraintViolationException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        Map<String, Object> msg = new HashMap<>();
        exception.getConstraintViolations().forEach(constraintViolation -> {
            String template = constraintViolation.getMessageTemplate();
            String path = constraintViolation.getPropertyPath().toString();
            msg.put(path, template);
        });
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        result.setMsg(msg);
        result.setErrorCode(ErrorCode.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * NoHandlerFoundException
     */
    @ExceptionHandler({NoHandlerFoundException.class})
    public CommonResult processException(NoHandlerFoundException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        String errorMessage = ErrorCodeConfig.getErrorMessage(10025);
        if (Strings.isNullOrEmpty(errorMessage)) {
            result.setMsg(exception.getMessage());
        } else {
            result.setMsg(errorMessage);
        }
        result.setErrorCode(ErrorCode.NOT_FOUND.getCode());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return result;
    }

    /**
     * MissingServletRequestParameterException
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public CommonResult processException(MissingServletRequestParameterException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());

        String errorMessage = ErrorCodeConfig.getErrorMessage(10150);
        if (Strings.isNullOrEmpty(errorMessage)) {
            result.setMsg(exception.getMessage());
        } else {
            result.setMsg(errorMessage + exception.getParameterName());
        }
        result.setErrorCode(ErrorCode.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * MethodArgumentTypeMismatchException
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public CommonResult processException(MethodArgumentTypeMismatchException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        String errorMessage = ErrorCodeConfig.getErrorMessage(10160);
        if (Strings.isNullOrEmpty(errorMessage)) {
            result.setMsg(exception.getMessage());
        } else {
            result.setMsg(exception.getValue() + errorMessage);
        }
        result.setErrorCode(ErrorCode.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * ServletException
     */
    @ExceptionHandler({ServletException.class})
    public CommonResult processException(ServletException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        result.setMsg(exception.getMessage());
        result.setErrorCode(ErrorCode.FAIL.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * MethodArgumentNotValidException
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public CommonResult processException(MethodArgumentNotValidException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        BindingResult bindingResult = exception.getBindingResult();
        List<ObjectError> errors = bindingResult.getAllErrors();
        Map<String, Object> msg = new HashMap<>();
        errors.forEach(error -> {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                msg.put(fieldError.getField(), fieldError.getDefaultMessage());
            } else {
                msg.put(error.getObjectName(), error.getDefaultMessage());
            }
        });
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        result.setMsg(msg);
        result.setErrorCode(ErrorCode.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * HttpMessageNotReadableException
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public CommonResult processException(HttpMessageNotReadableException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        String errorMessage = ErrorCodeConfig.getErrorMessage(10170);
        if (Strings.isNullOrEmpty(errorMessage)) {
            result.setMsg(exception.getMessage());
        } else {
            result.setMsg(errorMessage);
        }
        result.setErrorCode(ErrorCode.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * TypeMismatchException
     */
    @ExceptionHandler({TypeMismatchException.class})
    public CommonResult processException(TypeMismatchException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        result.setMsg(exception.getMessage());
        result.setErrorCode(ErrorCode.PARAMETER_ERROR.getCode());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
     * MaxUploadSizeExceededException
     */
    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public CommonResult processException(MaxUploadSizeExceededException exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        String errorMessage = ErrorCodeConfig.getErrorMessage(10180);
        if (Strings.isNullOrEmpty(errorMessage)) {
            result.setMsg(exception.getMessage());
        } else {
            result.setMsg(errorMessage + maxFileSize);
        }
        result.setErrorCode(ErrorCode.FILE_TOO_LARGE.getCode());
        response.setStatus(HttpStatus.PAYLOAD_TOO_LARGE.value());
        return result;
    }

    /**
     * Exception
     */
    @ExceptionHandler({Exception.class})
    public CommonResult processException(Exception exception, HttpServletRequest request, HttpServletResponse response) {
        log.error("", exception);
        CommonResult result = new CommonResult();
        result.setUrl(request.getServletPath());
        result.setMsg(ErrorCode.INTERNAL_SERVER_ERROR.getZhDescription());
        result.setErrorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }
}
