package proxy.test.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/9/29 下午4:33
 */
public class JdkInvocationHandler implements InvocationHandler {
    private Object object;

    public JdkInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 返回值的方法调用代理实例。如果声明的接口方法的返回类型是一个原始类型,
         * 那么这个方法返回的值必须是相应的原始包装器类的一个实例;否则,它必须是一种可转让声明返回类型。
         * 如果这个方法返回的值是null和接口方法的返回类型是原始的,那么就会抛出NullPointerException代理实例上的方法调用。
         * 如果这个方法返回的值是不兼容的接口方法的声明返回类型如上所述,将抛出一个ClassCastException代理上的方法调用实例。
         */
        Object result;
        if(method.getName().equals("getNum")){
            System.out.println("前置方法.." + method.getName()+"-----");
            result = method.invoke(object, args);
        }else{
            result = method.invoke(object, args);
            System.out.println("后置方法..."+args[0]);
        }
        return result;
    }
}
