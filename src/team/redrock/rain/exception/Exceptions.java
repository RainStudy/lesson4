package team.redrock.rain.exception;

import java.io.IOException;

/**
 * team.redrock.rain
 * lesson4
 *
 * @author 寒雨
 * @since 2022/10/30 下午2:57
 */
public class Exceptions {
    public static void main(String[] args) throws RuntimeException {
        assert 2 + 2 == 4;
    }

    public static void a() {
        b();
    }

    public static void b() {
        c();
    }

    public static void c() {
        throw new RuntimeException("程序执行错误!");
    }

    public static String get() {
        if (2 + 2 == 4) {
            return "所谓自由就是可以说2+2=4的自由";
        }
        // 虽然程序不可能走到这里，但这里如果不返回一个值的话就无法通过编译
        // 如果我们在这里抛出异常，程序就能直接通过编译
        throw new RuntimeException("2 + 2 != 4");
    }
}
