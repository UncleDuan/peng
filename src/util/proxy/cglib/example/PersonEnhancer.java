package util.proxy.cglib.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by pengsel on 2019/4/2.
 */
public class PersonEnhancer implements MethodInterceptor{



    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Cglib代理了");
        methodProxy.invokeSuper(o,objects);
        return null;
    }

    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new PersonEnhancer());
        Person person=(Person)enhancer.create();
        person.buy();

    }
}
