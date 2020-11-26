package main.java8.basics.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Title : main.java8.basics.proxy.jdk <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/26 10:27
 */
public class SystemProxyFactory {

    public static Object getProxyInstance(Object object) {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new SystemInvocationHandler(object));
    }

}
