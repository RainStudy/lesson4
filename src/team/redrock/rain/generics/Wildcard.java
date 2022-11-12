package team.redrock.rain.generics;

import java.util.ArrayList;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/4 下午5:18
 */
public class Wildcard {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Hello World");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(0);
        System.out.println(arrayListType(stringArrayList));
        System.out.println(arrayListType(integerArrayList));

        Integer i = 1;
        int number = i;

        // 通过，Integer是Number的子类
        printNumber(1);
        // 通过，Double是Number的子类
        printNumber(1.0d);
        // 不通过，String跟Number没有继承关系
//        printNumber("");
    }

    // 参数的类型ArrayList<?>使用了通配符，由于没有限制其界限，这里传入的可以是带有任意类型参数的ArrayList
    public static String arrayListType(ArrayList<?> list) {
        return list.get(0).getClass().getName();
    }

    public static <N extends Number> void printNumber(N number) {
        // 这里我们使用的时候就能发现，一旦指定了上界为Number，
        // 我们就可以在这个N类型的number参数上调用Number一切成员/方法
        // 如果我们不指定上界，上界默认为Object
        System.out.println(number.intValue());
    }
}
