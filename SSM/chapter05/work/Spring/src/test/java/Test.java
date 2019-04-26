import com.beerus.entiy.User;
import com.beerus.print.Printer;
import com.beerus.service.UserService;
import com.beerus.service.impl.UserServiceImpl;
import com.beerus.test.Greeting;
import com.beerus.utils.SpringUtil;

/**
 * @Author Beerus
 * @Description 测试类
 * @Date 2019/4/23
 **/
public class Test {
    /**
     * 测试说话方法
     */
    @org.junit.Test
    public void testSpeak() throws Exception {
        Greeting zhang = (Greeting) SpringUtil.getBean("zhang");
        zhang.speak();
        Greeting rod = (Greeting) SpringUtil.getBean("rod");
        rod.speak();
    }

    /**
     * 测试墨盒
     */
    @org.junit.Test
    public void testInk() throws Exception {
        Printer printer = (Printer) SpringUtil.getBean("printer");
        StringBuffer sb = new StringBuffer();
        sb.append("我们为所有 Bootstrap 插件提供了纯 JavaScript 方式的 API。所有公开的 API 都是支持单独或链式调用方式，并且返回其所操作的元素集合（注：和jQuery的调用形式一致）。");
        sb.append("$('.btn.danger').button('toggle').addClass('fat')");
        sb.append("所有方法都可以接受一个可选的 option 对象作为参数，或者一个代表特定方法的字符串，或者什么也不提供（在这种情况下，插件将会以默认值初始化）：");
        sb.append("$('#myModal').modal()                      // 以默认值初始化");
        sb.append("$('#myModal').modal({ keyboard: false })   // initialized with no keyboard");
        sb.append("$('#myModal').modal('show')                // 初始化后立即调用 show 方法");
        sb.append("每个插件还通过 Constructor 属性暴露了其原始的构造函数：$.fn.popover.Constructor。如果你想获取某个插件的实例，可以直接通过页面元素获取：$('[rel='popover']').data('popover')。");
        sb.append("默认设置");
        sb.append("每个插件都可以通过修改其自身的 Constructor.DEFAULTS 对象从而改变插件的默认设置：");
        printer.print(sb.toString());
    }

    /**
     * 测试AOP切面
     *
     * @throws Exception
     */
    @org.junit.Test
    public void testAop() throws Exception {
        UserService userServiceIMpl = (UserServiceImpl) SpringUtil.getBean("userServiceIMpl");
        userServiceIMpl.register(new User());
    }
}
