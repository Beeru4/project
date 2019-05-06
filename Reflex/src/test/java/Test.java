import pojo.User;

import java.lang.reflect.*;

/**
 * @Author Beerus
 * @Description 测试反射机制
 * @Date 2019-05-05
 **/
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1.User类还没有加载 在源文件就获取字节码对象   Class.forName("全限定类名");
        Class clazz = Class.forName("pojo.User");
        User user = (User) clazz.newInstance(); //这种默认是使用该类无参的构造方式实例化的
        System.out.println("1.age = " + user.age);

        //2.2、Class clazz2  = Person.class;当类被加载成.class文件时，此时Person类变成了.class，在获取该字节码文件对象，也就是获取自己， 该类处于字节码阶段

        //3.Class clazz3 = p.getClass();通过类的实例获取该类的字节码文件对象，该类处于创建对象阶段　


        // 获取指定构造器方法。constructor 如果没有无参构造，只有有参构造如何创建实例呢？
        Class clazzByCsg = Class.forName("pojo.User");
        Constructor constructor = clazzByCsg.getConstructor(String.class, Integer.class);
        user = (User) constructor.newInstance("张三", 18); //如果该类没有无参构造方法可使用这种方法
        System.out.println("2.age = " + user.age);


        //获取该类的所有构造方法
        Constructor[] constructors = clazzByCsg.getConstructors();
        //遍历构造方法
        int i = 0;
        for (Constructor csg : constructors) {
            i++;
            System.out.println("第" + i + "个构造方法");
            //获取每个构造函数当中的参数类型字节码对象
            Class[] typeParameters = csg.getParameterTypes();
            System.out.println(typeParameters);
            for (Class name : typeParameters) {
                //获取构造函数当中参数类型
                System.out.println(name.getName());
            }
            System.out.println("--------------------------------------");
        }


        //获取该类的局部变量 获取公开成员变量 clazz.getField(name) name = 来获取指定变量  返回 Field对象
        //Field age = clazz.getField("age");
        Field userName = clazz.getDeclaredField("userName");
        //获得对象是私有的 还要让其打开可见权限
        userName.setAccessible(true);
        //对其成员对象进行赋值
        userName.set(user, "testUserName");
        //获取成员对象的值
        System.out.println(userName.get(user));


        user.age = 20;
        //将是有的属性一并获得
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            //打开权限
            field.setAccessible(true);
            //获取成员变量的值
            System.out.println(field.get(user));
        }


        //获取该类的Public方法  clazz.getMethod(name,parameterType) name = 方法名  parameterType = 参数类型.class 参数没有则不填
        Method sport1 = clazz.getMethod("sport", String.class);
        //调用方法   sport.invoke(obj,args);  obj = 方法的对象  args = 实际参数的值 没有则不填写
        sport1.invoke(user, "1.8");

        //获取私有方法
        Method sport2 = clazz.getDeclaredMethod("sport");
        //和设置属性一样 打开其可见权限
        sport2.setAccessible(true);
        sport2.invoke(user);


        //同理 也能一次获取所有方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            //打开权限
            method.setAccessible(true);
            System.out.println("方法名:" + method.getName());
            System.out.println("==========================================");
            //获得方法的参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class clpp : parameterTypes) {
                //打印参数类型
                System.out.println(clpp.getName());
            }
        }

        //获得该类的所有接口
        //
        //　　　　　　　　　Class[]　getInterfaces()：确定此对象所表示的类或接口实现的接口
        //
        //　　　　　　　　　返回值：接口的字节码文件对象的数组


    }
}
