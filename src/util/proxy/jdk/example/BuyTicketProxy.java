package util.proxy.jdk.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pengsel on 2019/4/2.
 */
public class BuyTicketProxy implements InvocationHandler {
    public BuyTicket person;
    public BuyTicketProxy(BuyTicket p){
        this.person=p;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理：");
        method.invoke(person,args);
        return null;
    }

    public static void main(String[] args) {
        BuyTicket p=new Person();
        BuyTicketProxy proxy=new BuyTicketProxy(p);
        BuyTicket pr= (BuyTicket) Proxy.newProxyInstance(p.getClass().getClassLoader(),p.getClass().getInterfaces(),proxy);
        pr.buy();

    }
}
