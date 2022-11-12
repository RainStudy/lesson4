package team.redrock.rain.reflection;

import java.lang.reflect.Field;

/**
 * team.redrock.rain.reflection.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/11 下午10:11
 */
public class Annotation {

    @AutoWired
    int paramA;

    @AutoWired("王鸿杨姐姐的身高")
    int paramB;

    public void printA() {
        System.out.println(paramA);
    }

    public void printB() {
        System.out.println(paramB);
    }

    public static void main(String[] args) throws IllegalAccessException {
        Annotation annotation = new Annotation();
        inject(annotation);
        annotation.printA();
        annotation.printB();
    }

    public static void inject(Object obj) throws IllegalAccessException {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        // 遍历所有字段
        for (Field field : declaredFields) {
            // 如果字段被Autowired修饰
            if (field.isAnnotationPresent(AutoWired.class)) {
                // 得到注解对象
                AutoWired autoWired = field.getAnnotationsByType(AutoWired.class)[0];
                // 允许越权访问私有字段
                field.setAccessible(true);
                // 根据注解中的信息设置字段的值
                if (autoWired.value().equals("王鸿杨姐姐的身高")) {
                    field.set(obj, 175);
                } else {
                    field.set(obj, 114514);
                }
            }
        }
    }
}
