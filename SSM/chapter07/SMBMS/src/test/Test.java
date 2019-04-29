import com.beerus.entity.Role;
import com.beerus.entity.User;
import com.beerus.mapper.BillMapper;
import com.beerus.mapper.ProvideMapper;
import com.beerus.mapper.RoleMapper;
import com.beerus.service.UserService;
import com.beerus.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author Beerus
 * @Description 测试类
 * @Date 2019-04-28
 **/
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    /**
     * 测试SqlSessionTemplate
     */
    @org.junit.Test
    public void testTemplate() throws Exception {
        BillMapper billMapper = (BillMapper) SpringUtil.getBean("billMapper");
        logger.debug(billMapper.list_FindBillByFilterOrPage(new HashMap<String, Object>() {{
            put("currPageNo", 2);
            put("pageSize", 10);
            put("providerId", null);
            put("productName", null);
            put("isPayment", null);
        }}).toString());
    }

    /**
     * 测试SqlSessionDaoSupport
     */
    @org.junit.Test
    public void testDaoSupport() throws Exception {
        ProvideMapper provideMapper = (ProvideMapper) SpringUtil.getBean("provideMapper");
        System.out.println(provideMapper.list_FindProvAll());
    }

    /**
     * 测试MapperFactoryBean
     */
    @org.junit.Test
    public void testMapperFactoryBean() throws Exception {
        RoleMapper roleMapper = (RoleMapper) SpringUtil.getBean("roleMapper");
        System.out.println(roleMapper.list_Role());
    }

    /**
     * 测试MapperScannerConfigurer
     */
    @org.junit.Test
    public void testMapperScannerConfigurer() throws Exception {
        UserService userMapper = (UserService) SpringUtil.getBean("userService");
        logger.debug(userMapper.login("admin", "123").getAddress());
    }

    /**
     * 测试XML事务增强(查询)
     */
    @org.junit.Test
    public void testTxActiveBySelect() throws Exception {
        RoleMapper roleMapper = (RoleMapper) SpringUtil.getBean("roleMapper");
        System.out.println(roleMapper.list_Role());
    }

    /**
     * 测试XML事务增强(增加)
     */
    @org.junit.Test
    public void testTxActiveBySave() throws Exception {
        UserService userMapper = (UserService) SpringUtil.getBean("userService");
        User user = new User();
        user.setCreateBy(1001);
        user.setUserPassword("testPassword");
        user.setAddress("testAddress");
        user.setAge(12);
        user.setBirthday(new Date());
        user.setCreationDate(new Date());
        user.setGender(1);
        user.setPhone("testPhone");
        Role role = new Role();
        role.setId(1);
        user.setRole(role);
        user.setUserCode("testUserCode");
        user.setUserName("testUserName11");
        userMapper.save_User(user);
    }
}
