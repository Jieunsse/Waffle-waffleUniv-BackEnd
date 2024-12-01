package gdg.waffle.BE.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;


import gdg.waffle.BE.common.base.ApiResult;
import gdg.waffle.BE.common.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===========================================================================

    @ResponseStatus(code = NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ApiResult<?> handleNotFoundException(final NotFoundException e) {
        log.error(e.getMessage(), e);

        return ApiResult.of(e);
    }

    @ResponseStatus(code = BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ApiResult<?> handleBusinessException(final BusinessException e) {
        log.error(e.getMessage(), e);
        ExceptionMDCBuilder.getStringStringMap(e);

        return ApiResult.of(e);
    }
}
