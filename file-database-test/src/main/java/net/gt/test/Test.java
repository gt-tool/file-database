package net.gt.test;

import net.gt.core.mapper.BaseFileMapper;
import net.gt.test.filemapper.UserFileMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2022/12/18
 */
public class Test {


    /*private static Class<?> extractModelClass(Class<?> mapperClass) {
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
    }*/

    public static void main(String[] args) {
//        System.out.println(extractModelClass(UserFileMapper.class));
    }

}
