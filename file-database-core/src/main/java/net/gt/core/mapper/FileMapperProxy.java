package net.gt.core.mapper;

import net.gt.core.mapper.impl.BaseFileMapperImpl;
import net.gt.core.param.QueryParam;
import net.gt.core.util.ClassUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理，需要注意的是，这里用到的是JDK自带的动态代理，代理对象只能是接口，不能是类
 *
 * @author jason
 */

public class FileMapperProxy<T> implements InvocationHandler {
    private final Class<T> interfaceType;

    public FileMapperProxy(Class<T> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (BaseFileMapper.class.equals(method.getDeclaringClass())) {

            String methodName = method.getName();

            Class<?> aClass = ClassUtil.extractModelClass(interfaceType);

            QueryParam<T> arg = (QueryParam<T>) args[0];

            BaseFileMapper<T> baseFileMapper = new BaseFileMapperImpl<T>();

            Object result = baseFileMapper.selectOne(arg);

//            Object result = method.invoke(interfaceType, args);

            System.out.println("调用前，参数：{}" + args);
            // 这里可以得到参数数组和方法等，可以通过反射，注解等，进行结果集的处理
            // mybatis就是在这里获取参数和相关注解，然后根据返回值类型，进行结果集的转换
//            Object result = JSON.toJSONString(args);
            System.out.println("调用后，结果：{}" + result);
            return result;
        }

        return method.invoke(this, args);
    }
}