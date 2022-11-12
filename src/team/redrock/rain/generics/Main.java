package team.redrock.rain.generics;

import java.util.ArrayList;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/3 下午9:14
 */
public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add("123");
        int num = (int) list.get(0);
        System.out.println(num);
    }
}
