package team.redrock.rain.generics;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/4 下午4:46
 */
public class GenericMethod {
    public static <T> void testIn(T param) {

    }

    @SuppressWarnings("unchecked")
    public static <T> T testOut(Object obj) {
        return (T) obj;
    }

    // 当然 非静态方法也可以使用方法泛型，不过仔细想想就明白，静态方法是没有办法使用类泛型的
    public <T> void test(T param) {

    }
}
