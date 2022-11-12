package team.redrock.rain.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * team.redrock.rain.reflection.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/11 上午11:34
 */
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 通过Class.forName拿到Class对象
        Class<?> aClass = Class.forName("team.redrock.rain.reflection.ReflectClass");
        // 通过class可以拿到类的一些信息
        // 类名
        String name = aClass.getName();
        // 获得这个类声明的所有字段对象 （无论是静态还是非静态，但不包括通过继承得来的）
        Field[] declaredFields = aClass.getDeclaredFields();
        // 获得这个类的所有字段对象 （包括继承得来的）
        Field[] fields = aClass.getFields();
        // 获得这个类声明的所有方法对象 （无论是静态还是非静态，但不包括通过继承得来的）
        Method[] declaredMethods = aClass.getDeclaredMethods();
        // 获得这个类的所有方法（包括继承得来的）
        Method[] methods = aClass.getMethods();

        // 获得无参构造器
        Constructor<?> constructor = aClass.getConstructor();
        // 获得有参构造器
        Constructor<?> parameterizedConstructor = aClass.getDeclaredConstructor(int.class, int.class);
        // 因为这个构造器是私有的，所以需要setAccessible，否则会报错
        parameterizedConstructor.setAccessible(true);
        // 调用构造器new一个ReflectClass
        Object o = constructor.newInstance();
        // 调用有参构造器，传入参数
        o = parameterizedConstructor.newInstance(1, 2);

        // 获取字段
        Field field = aClass.getDeclaredField("var0");
        // 因为是private的字段，所以需要绕过访问权限
        field.setAccessible(true);
        // 获得这个实例上的var0字段的值
        int var0 = (int) field.get(o);
        System.out.println(var0);
        // public的字段就不需要setAccessible
        field = aClass.getDeclaredField("var1");
        int var1 = (int) field.get(o);

        // 修改字段
        // 即便是final的字段，也可以用反射修改
        // 因为是private，才需要setAccessible
        Field var2Field = aClass.getDeclaredField("var2");
        var2Field.setAccessible(true);
        // 修改这个对象的字段为1
        var2Field.set(o, 1);

        // 获取 & 修改静态字段
        // 实例直接填null就完事了
        Field var3Field = aClass.getDeclaredField("var3");
        var3Field.setAccessible(true);
        var3Field.set(null, 1);
        int var3 = (int) var3Field.get(null);

        // 调用方法, 根据参数类型和方法名称获得精确的方法
        // 因为同名方法可能有重载
        Method method1 = aClass.getDeclaredMethod("method1", int.class, int.class);
        method1.invoke(o, 1, 1);

        // 调用private方法
        Method method2 = aClass.getDeclaredMethod("method2");
        method2.setAccessible(true);
        method2.invoke(o);

        // 调用静态方法
        Method method3 = aClass.getDeclaredMethod("method3");
        method3.setAccessible(true);
        // 取得返回值
        int returnValue = (int) method3.invoke(null);
        System.out.println(returnValue);
    }
}
