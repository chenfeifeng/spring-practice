package bulid.test;

public class SpringTest {

    public static void main(String[] args) {
        // 构造器模式
        People p = new People.PeopleBulid().setAge("123222").setLiking("no").setName("zhangsan")
                .setSex("woman").build();
        System.out.println(p);

    }

}
