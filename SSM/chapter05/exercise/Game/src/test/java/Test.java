import com.beerus.entity.Equip;
import com.beerus.service.EquipService;
import com.beerus.utils.SpringUtil;
import org.apache.log4j.Logger;


/**
 * @Author Beerus
 * @Description 测试类
 * @Date 2019/4/23
 **/
public class Test {
    private Logger logger = Logger.getLogger(Test.class);

    /**
     * 测试输出蓝魔指环
     */
    @org.junit.Test
    public void testPrinterRing() {
        logger.debug(SpringUtil.getBean("lanMoRing"));
    }

    /**
     * 测试修改指环
     */
    @org.junit.Test
    public void testLeaveRing() throws Exception {
        Equip equip = null;
        //得到靴子对象
        equip = (Equip) SpringUtil.getBean("boShiBoot");
        //得到指环对象
        //equip = (Equip) SpringUtil.getBean("lanMoRing");
        try {
            ((EquipService) SpringUtil.getBean("equipService")).leave_Ring(equip);
            //更新成功
            logger.debug("update success!--------------->" + equip.getName());
        } catch (Exception e) {
            //更新失败
            logger.debug("update error!--------------->" + equip.getName());
            throw new Exception("update error!");
        }
    }
}
