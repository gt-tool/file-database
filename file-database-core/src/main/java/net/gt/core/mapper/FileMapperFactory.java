package net.gt.core.mapper;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 类描述
 *
 * @author gt-it
 * @since 2023/1/25
 */
public class FileMapperFactory<T> implements FactoryBean<T> {

    private Class<T> interfaceType;

    public FileMapperFactory(Class<T> interfaceType) {
        this.interfaceType = interfaceType;
    }

    @Override
    @SuppressWarnings("all")
    public T getObject() throws Exception {
        //这里主要是创建接口对应的实例，便于注入到spring容器中
        InvocationHandler handler = new FileMapperProxy<>(interfaceType);
        return (T) Proxy.newProxyInstance(interfaceType.getClassLoader(),
                new Class[]{interfaceType}, handler);
    }

    @Override
    public Class<T> getObjectType() {
        return interfaceType;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
