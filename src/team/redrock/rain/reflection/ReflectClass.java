package team.redrock.rain.reflection;

/**
 * team.redrock.rain.reflection.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/11 上午11:34
 */
public class ReflectClass {
    private int var0;
    public int var1;
    private final int var2 = 0;

    private static int var3;

    public ReflectClass() {

    }

    private ReflectClass(int var0, int var1) {
        this.var0 = var0;
        this.var1 = var1;
    }

    public void method1(int arg0, int arg1) {
        System.out.println("Method 1");
    }

    private void method2() {
        System.out.println("Method 2");
    }

    private static int method3() {
        System.out.println("Method 3");
        return 1;
    }
}
