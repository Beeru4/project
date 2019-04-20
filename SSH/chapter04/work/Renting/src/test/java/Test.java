import com.beerus.entity.Users;
import com.beerus.service.UserService;
import com.beerus.service.impl.UserServiceImpl;


/**
 * 测试类
 */
public class Test {
    UserService userService = new UserServiceImpl();

    /**
     * 测试增加
     */
    @org.junit.Test
    public void testAdd() {
        Users u = new Users();
        u.setId(1201);
        u.setIsadmin("2");
        u.setName("张三");
        u.setPassword("12312");
        u.setTelephone("1111111111");
        u.setUsername("张三");
        userService.addUser(u);
        System.out.println("成功!");

    }

    /**
     * 测试查询
     */
    @org.junit.Test
    public void testQuery() {
        //按id查询
        Users u = userService.query(Users.class, 1234);
        //注意 这里使用Load的话报异常 org.hibernate.LazyInitializationException: could not initialize proxy - no Session
        //因为业务层关闭了会话 所以这边访问不了
        System.out.println(u.getName());
    }

    /**
     * 测试修改
     */
    @org.junit.Test
    public void testUpdate() {
        Users u = userService.query(Users.class, 1234);
        u.setUsername("修改后的张三");
        userService.update(u);
    }

    /**
     * 测试删除
     */
    @org.junit.Test
    public void testDel(){
        userService.delete(new Users(1201));
    }

    /**
     * 测试脏检查
     */
    @org.junit.Test
    public  void testAddData(){

    }
}
