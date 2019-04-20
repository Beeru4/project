import com.beerus.dao.DescDao;
import com.beerus.dao.impl.DescDaoImpl;
import com.beerus.entity.Desc;

/**
 * 测试类
 */
public class Test {
    @org.junit.Test
    public void testListAll() {
        DescDao descDao = new DescDaoImpl();
        for(Desc desc:descDao.list_All()){
            System.out.println(desc.getType());
        }
    }
}
