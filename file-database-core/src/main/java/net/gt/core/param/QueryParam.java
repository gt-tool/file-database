package net.gt.core.param;

import java.io.Serializable;

/**
 * 查询参数
 *
 * @author gt-it
 * @since 2023/1/30
 */
public class QueryParam<T> implements Serializable {

    private static final long serialVersionUID = -2626314024258610201L;

    private Class<T> clazz;

    public QueryParam() {
    }

    public QueryParam(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
