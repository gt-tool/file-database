package net.gt.core.exception;

/**
 * 文件数据库自定义异常
 *
 * @author gt-it
 * @since 2022/12/13
 */
public class FileDatabaseException extends RuntimeException {

    private static final long serialVersionUID = -94963973430289519L;

    public FileDatabaseException(String message) {
        super(message);
    }

    public FileDatabaseException(Throwable cause) {
        super(cause);
    }

    public FileDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
