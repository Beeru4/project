import com.beerus.entiy.User;
import com.beerus.service.UserService;
import com.beerus.test.Greeting;
import com.beerus.test.Greeting2;
import com.beerus.utils.SpringUtil;

/**
 * @Author Beerus
 * @Description 测试类
 * @Date 2019/4/23
 **/
public class Test {
    /**
     * 测试使用构造方法的方式注入
     */
    @org.junit.Test
    public void testConstructorIOC() {
        //得到说话对象
        Greeting zhang = (Greeting) SpringUtil.getBean("zhang");
        Greeting rod = (Greeting) SpringUtil.getBean("rod");

        //说话
        zhang.speak();
        rod.speak();
    }


    /**
     * 测试使用P命名空间注入
     */
    @org.junit.Test
    public void testPNameSpance() {
        //得到说话对象
        Greeting2 zhang = (Greeting2) SpringUtil.getBean("zhang2");
        Greeting2 rod = (Greeting2) SpringUtil.getBean("rod2");

        //说话
        zhang.speak();
        rod.speak();
    }


    /**
     * 测试使用P命名空间注入业务DaoBean
     */
    @org.junit.Test
    public void testPIOCBean() throws Exception {
        ((UserService) SpringUtil.getBean("userService")).register(new User());
    }

    /**
     * 测试环绕增强
     */
    @org.junit.Test
    public void testAround() throws Exception {
        ((UserService) SpringUtil.getBean("userService")).register(new User());
    }
}
