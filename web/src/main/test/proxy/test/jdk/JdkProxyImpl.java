package proxy.test.jdk;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/9/29 下午4:31
 */
public class JdkProxyImpl implements IJdkProxy {

    @Override
    public void getName(String name) {
        System.out.println("invoke in method:"+name);
    }

    @Override
    public Integer getNum(Integer num) {
        System.out.println(num);
        return null;
    }
}
