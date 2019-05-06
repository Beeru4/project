package pojo;

/**
 * @Author Beerus
 * @Description 测试反射机制
 * @Date 2019-05-05
 **/
public class User {
    private String userName;
    public Integer age;


    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    private void sport() {
        System.out.println("我叫:" + this.userName + "我已经" + this.age + "岁了,我正在运动!");
    }

    public void sport(String height) {
        System.out.println("我叫:" + this.userName + "我已经" + this.age + "岁了,我的身高为" + height + ",我正在运动!");
    }

}
