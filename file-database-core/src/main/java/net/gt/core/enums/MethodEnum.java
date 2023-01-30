package net.gt.core.enums;

/**
 * 方法枚举
 *
 * @author gt-it
 * @since 2023/1/30
 */
public enum MethodEnum {

    /**
     * 查询一条数据
     */
    SELECT_ONE("selectOne");

    /**
     * 方法名称
     */
    private final String methodName;

    MethodEnum(String methodName) {
        this.methodName = methodName;
    }
}
