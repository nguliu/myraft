package org.nguliu.myraft.common.utils.exception;

import org.nguliu.myraft.common.utils.enums.ErrorCodeEnum;

public class MyraftException extends RuntimeException {

    private final ErrorCodeEnum errorCode;

    public MyraftException(ErrorCodeEnum errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public MyraftException(ErrorCodeEnum errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public MyraftException(ErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode.getDesc(), cause);
        this.errorCode = errorCode;
    }

    public MyraftException(ErrorCodeEnum errorCode, String msg, Throwable cause) {
        super(msg, cause);
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}
