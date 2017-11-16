package bulid.test;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/9/29 下午2:21
 */
public class People {

    private String name;

    private String age;

    private String sex;

    private String liking;


    public void setName(String name) {
        this.name = name;
    }


    public void setAge(String age) {
        this.age = age;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public void setLiking(String liking) {
        this.liking = liking;
    }

    public People(String name, String age, String sex, String liking) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.liking = liking;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", liking='" + liking + '\'' +
                '}';
    }

    public static class PeopleBulid {
        private String name;

        private String age;

        private String sex;

        private String liking;

        public PeopleBulid setName(String name) {
            this.name = name;
            return this;
        }

        public PeopleBulid setAge(String age) {
            this.age = age;
            return this;
        }

        public PeopleBulid setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public PeopleBulid setLiking(String liking) {
            this.liking = liking;
            return this;
        }

        public People build() {
            return new People(this.name, this.age, this.sex, this.liking);
        }
    }
}


