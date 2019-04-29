import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Beerus
 * @Description 测试slf4j
 * @Date 2019-04-28
 **/
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    /**
     * 测试SLF4J
     */
    @org.junit.Test
    public void testSLF4J() {
        logger.debug("debug");
        logger.error("error");
        logger.info("info");
    }
}
