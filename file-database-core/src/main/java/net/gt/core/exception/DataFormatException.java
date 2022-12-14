package net.gt.core.exception;

/**
 * 数据格式化异常
 *
 * @author gt-it
 * @since 2022/12/13
 */
public class DataFormatException extends RuntimeException {

    private static final long serialVersionUID = -94963973430289519L;

    public DataFormatException(String message) {
        super(message);
    }

    public DataFormatException(String message, Throwable e) {
        super(message, e);
    }

}
