package main.java8.basics.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Title : main.java8.basics.proxy.jdk <br>
 * Description :
 *
 *
 * @author chile
 * @version 1.0
 * @date 2020/11/26 10:23
 */
public class SystemInvocationHandler implements InvocationHandler {

    private Object target;

    public SystemInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object result = method.invoke(target, args);
        System.out.println("after invoke");
        return result;
    }


}
