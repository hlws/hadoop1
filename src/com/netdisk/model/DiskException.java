package com.netdisk.model;

/**
 * @Classname DiskException
 * @Description TODO
 * @Date 2020-3-23 16:20
 * @Created by lishaoteng
 */
public class DiskException extends RuntimeException {
    public DiskException() {
        super();
    }

    public DiskException(String message) {
        super(message);
    }

    public DiskException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiskException(Throwable cause) {
        super(cause);
    }

    protected DiskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
