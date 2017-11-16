package proxy.test.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/9/29 下午4:35
 */
public class Main {

    @Test
    public void proxyOne() throws Exception {
        JdkProxyImpl impl = new JdkProxyImpl();
        //建立代理类和目标之间的关联关系
        JdkInvocationHandler handler = new JdkInvocationHandler(impl);
        IJdkProxy proxy= (IJdkProxy) Proxy.newProxyInstance(
                impl.getClass().getClassLoader(),
                impl.getClass().getInterfaces(),
                handler);

        proxy.getName("cff");
        System.out.println("============");
        proxy.getNum(1);

    }


    @Test
    public void proxyMore() throws Exception {
        JdkProxyImpl impl=new JdkProxyImpl();
        JdkInvocationHandler handler=new JdkInvocationHandler(impl);
        IJdkProxy proxy= (IJdkProxy) Proxy.newProxyInstance(impl.getClass().getClassLoader(),impl.getClass().getInterfaces(),handler);

        proxy.getName("cff");
        proxy.getNum(1);

        System.out.println("=====");
        // 2次代理
        handler=new JdkInvocationHandler(proxy);
        IJdkProxy proxy2= (IJdkProxy) Proxy.newProxyInstance(impl.getClass().getClassLoader(),impl.getClass().getInterfaces(),handler);
        proxy2.getName("cff2");
        proxy2.getNum(2);

        System.out.println("=====");
        // 多次代理
        handler=new JdkInvocationHandler(proxy2);
        IJdkProxy proxy3= (IJdkProxy) Proxy.newProxyInstance(impl.getClass().getClassLoader(),impl.getClass().getInterfaces(),handler);
        proxy3.getName("cff3");
        proxy3.getNum(3);
    }
}
