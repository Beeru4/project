import com.beerus.entity.SmbmsBill;
import com.beerus.entity.SmbmsProvider;
import com.beerus.entity.SmbmsRole;
import com.beerus.service.impl.BillServiceImpl;
import com.beerus.service.impl.ProvideServiceImpl;
import com.beerus.service.impl.RoleServiceImpl;
import com.beerus.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Beerus
 * @Description 测试类
 * @Date 2019/4/19
 **/
public class Test {
    private Logger logger = Logger.getLogger(Test.class);


    /**
     * 测试查询总行数(根据映射类查询)
     */
    @org.junit.Test
    public void testCount_TotalRow() throws Exception {
        logger.debug("Total_Count-------------:" + new ProvideServiceImpl().count_TotalRow());
    }

    /**
     * 测试查询总行数(不根据映射类查询)
     */
    @org.junit.Test
    public void testCount_TotalRow2() throws Exception {
        logger.debug("Total_Count-------------:" + new ProvideServiceImpl().count_TotalRow2());
    }

    /**
     * 测试查询所有供应商
     */
    @org.junit.Test
    public void testList_FindAll() throws Exception {
        //修改为分页查询
        new ProvideServiceImpl().list_FindAll(1, 5).getPages().forEach(prov -> logger.debug(prov));

    }

    /**
     * 测试按条件查询所有订单
     */
    @org.junit.Test
    public void testList_ByFilter() throws Exception {
        //设置查询条件
        SmbmsBill smbmsBill = new SmbmsBill();
        smbmsBill.setProductName("米");
        smbmsBill.setProviderId(4403);
        smbmsBill.setIsPayment(2);
        List<SmbmsBill> pages = new BillServiceImpl().findAllByFilter(smbmsBill, 0, 0).getPages();
        if (null != pages)
            //遍历数据
            for (SmbmsBill bill : pages) {
                logger.debug("bill1------------>" + bill);
                //循环订单下的供应商下的集合
                for (SmbmsBill bill2 : bill.getProvider().getSmbmsBills()) {
                    logger.debug("bill2--------->" + bill.getBillCode());
                }
            }
    }

    /**
     * 测试添加订单
     */
    @org.junit.Test
    public void testSave_Prove() throws Exception {
        //添加供应商
        SmbmsProvider smbmsProvider = new SmbmsProvider();
        smbmsProvider.setProName("test1");
        smbmsProvider.setCreateBy(1101);
        smbmsProvider.setCreationDate(new Date());
        smbmsProvider.setProAddress("testAddress");
        smbmsProvider.setProCode("testCode");
        smbmsProvider.setProContact("testContact");
        smbmsProvider.setProDesc("testDesc");
        smbmsProvider.setProFax("testProFax");
        smbmsProvider.setProPhone("testPhone");
        logger.debug(new ProvideServiceImpl().save_Prov(smbmsProvider));
    }

    /**
     * 测试修改订单
     */
    @org.junit.Test
    public void testUpdate_Prove() throws Exception {
        SmbmsProvider smbmsProvider = new SmbmsProvider();
        smbmsProvider.setId(4415);
        smbmsProvider.setProName("2");
        smbmsProvider.setProAddress("2");
        smbmsProvider.setProContact("2");
        logger.debug(new ProvideServiceImpl().update_Prov(smbmsProvider));
    }

    /**
     * 测试删除订单
     */
    @org.junit.Test
    public void testDelete_Prove() throws Exception {
        logger.debug(new ProvideServiceImpl().delete_Prov(4416));
    }

    /**
     * 测试保存角色
     */
    @org.junit.Test
    public void testSave_Role() throws Exception {
        //创建添加的角色
        SmbmsRole smbmsRole = new SmbmsRole();
        smbmsRole.setCreateBy(1101);
        smbmsRole.setCreationDate(new Date());
        smbmsRole.setRoleCode("testRole");
        smbmsRole.setRoleName("testRoleName");
        logger.debug(new RoleServiceImpl().save_Role(smbmsRole));
    }

    /**
     * 测试修改角色
     */
    @org.junit.Test
    public void testUpdate_Role() throws Exception {
        SmbmsRole smbmsRole = new SmbmsRole();
        smbmsRole.setId(6);
        smbmsRole.setRoleName("testUpdateRoleName");
        logger.debug(new RoleServiceImpl().update_Role(smbmsRole));
    }

    /**
     * 测试删除角色
     */
    @org.junit.Test
    public void testDelete_Role() throws Exception {
        logger.debug(new RoleServiceImpl().delete_Role(3));
    }

    /**
     * 测试按角色名称模糊查询角色
     */
    @org.junit.Test
    public void testList_FindByRoleName() throws Exception {
        new RoleServiceImpl().list_findByName("S").forEach(role -> logger.debug(role));
    }

    /**
     * 测试登录
     */
    @org.junit.Test
    public void testLogin() throws Exception {
        logger.debug(new UserServiceImpl().login("admin", "123").getAddress());
    }

    /**
     * 测试根据数组in查询订单
     */
    @org.junit.Test
    public void testList_FindByArray() throws Exception {
        List<SmbmsBill> smbmsBills = new BillServiceImpl().list_findByInAndArray(new Integer[]{4401, 4408, 4410});
        if (null != smbmsBills)
            //循环遍历集合
            smbmsBills.forEach(bill -> logger.debug(bill));
    }

    /**
     * 测试根据List集合in查询订单
     */
    @org.junit.Test
    public void testList_FindByList() throws Exception {
        List<SmbmsBill> smbmsBills = new BillServiceImpl().list_findByInAndList(asList(4401, 4404, 4406));
        if (null != smbmsBills)
            //循环遍历集合
            smbmsBills.forEach(bill -> logger.debug(bill));
    }

    /**
     * 测试根据Map集合in查询订单
     */
    @org.junit.Test
    public void testList_FindByMap() throws Exception {
        List<SmbmsBill> smbmsBills = new BillServiceImpl().list_findByInAdnMap(new HashMap<String, Object>() {{
            put("productName", "杯");
            put("provIds", Arrays.asList(4414, 4418));
        }});
        if (null != smbmsBills)
            //循环遍历集合
            smbmsBills.forEach(bill -> logger.debug(bill));
    }

    /**
     * 测试根据条件+choose查询供应商
     */
    @org.junit.Test
    public void testList_FindProvByFilter() throws Exception {
        //设置查询条件
        SmbmsProvider smbmsProvider = new SmbmsProvider();
        smbmsProvider.setProName("公司");
        smbmsProvider.setProCode("ZJ");
        List<SmbmsProvider> smbmsProviders = new ProvideServiceImpl().list_FindByFilter(smbmsProvider);
        if (null != smbmsProviders)
            smbmsProviders.forEach(prov -> logger.debug(prov));
    }
}
