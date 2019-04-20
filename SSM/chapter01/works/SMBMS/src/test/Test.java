import com.beerus.service.impl.ProvideServiceImpl;
import org.apache.log4j.Logger;

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
       new ProvideServiceImpl().list_FindAll().forEach(prov -> logger.debug(prov));
    }
}
