import com.cff.spring.spi.SpiFactory;
import com.cff.spring.spi.SpiTestApi;

/**
 * Created by cff on 2017/6/8.
 */
public class Test {

    public static void main(String[] args) {
        SpiTestApi spi = SpiFactory.getSpiFactory();
        if (spi != null) {
            spi.dealTest();
        } else {
            System.out.println("null");
        }
        System.out.println("测试修改");
    }
}
