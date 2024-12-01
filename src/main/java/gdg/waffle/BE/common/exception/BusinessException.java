package gdg.waffle.BE.common.exception;

import gdg.waffle.BE.common.exception.code.ExceptionCode;

public class BusinessException extends CustomException {

    public BusinessException(ExceptionCode resultCode) {
        super(resultCode);
    }

    public BusinessException(ExceptionCode resultCode, Object data) {
        super(resultCode, data);
    }
}
