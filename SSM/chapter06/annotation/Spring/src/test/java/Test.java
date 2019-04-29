import com.beerus.entiy.User;
import com.beerus.service.UserService;
import com.beerus.test.Greeting;
import com.beerus.test.Greeting2;
import com.beerus.utils.SpringUtil;

/**
 * @Author Beerus
 * @Description 测试类(使用注解)
 * @Date 2019/4/23
 **/
public class Test {
    /**
     * 测试上机练习4
     */
    @org.junit.Test
    public void testWork04() throws Exception {
        this.test();
    }

    /**
     * 测试上机练习5
     */
    @org.junit.Test
    public void testWork05() throws Exception {
        this.test();
    }

    /**
     * 测试上机练习6
     */
    @org.junit.Test
    public void testWork06() throws Exception {
        this.test();
    }

    /**
     * 一样的代码 提取到这个方法内
     *
     * @throws Exception
     */
    private void test() throws Exception {
        UserService userService = (UserService) SpringUtil.getBean("userService");
        userService.register(new User());
    }

}
