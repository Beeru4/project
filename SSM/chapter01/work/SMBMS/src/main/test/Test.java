import com.beerus.dao.ProviderDao;
import com.beerus.dao.impl.ProviderDaoImpl;
import com.beerus.entity.SmbmsProvider;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Author Beerus
 * @Description 测试类
 * @Date 2019/4/18
 **/
public class Test {
    //log4j日志
    private static Logger logger = Logger.getLogger(Test.class);
    //供应商数据层
    private ProviderDao providerDao = new ProviderDaoImpl();

    /**
     * 得到供应商总行数
     */
    @org.junit.Test
    public void testCount_Row() throws Exception {
        logger.debug("COUNT_ROW-------------" + providerDao.count_Total());
    }

    /**
     * 根据Mapper直查询供应商
     */
    @org.junit.Test
    public void testListALlProv() {
        List<SmbmsProvider> smbmsProviders = providerDao.listAllProv();
        for (SmbmsProvider provider : smbmsProviders) {
            logger.debug(provider);
        }
    }

    /**
     * 根据映射直查询供应商
     */
    @org.junit.Test
    public void testListAllByMapperXML() {
        List<SmbmsProvider> smbmsProviders = providerDao.listALlProvByMapperXML();
        for (SmbmsProvider provider : smbmsProviders) {
            logger.debug(provider);
        }
    }
}
