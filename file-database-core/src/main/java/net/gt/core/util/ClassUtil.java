package net.gt.core.util;

import net.gt.core.mapper.BaseFileMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具类
 *
 * @author gt-it
 * @since 2022/12/18
 */
public class ClassUtil {

    private ClassUtil() {
    }

    /**
     * 获取类/接口上的泛型
     *
     * @param mapperClass 类/接口
     * @return 泛型Class
     */
    public static Class<?> extractModelClass(Class<?> mapperClass) {
        Type[] types = mapperClass.getGenericInterfaces();
        ParameterizedType target = null;
        for (Type type : types) {
            if (type instanceof ParameterizedType && ((ParameterizedType) type).getRawType().equals(BaseFileMapper.class)) {
                target = (ParameterizedType) type;
                break;
            }
        }
        Type[] parameters = target.getActualTypeArguments();
        Class<?> modelClass = (Class<?>) parameters[0];
        return modelClass;
    }

}
