package team.redrock.rain.generics;

import java.util.ArrayList;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/3 下午9:48
 */
public class GenericArrayList<E> {
    private ArrayList internalArrayList = new ArrayList();

    public E get(int index) {
        return (E) internalArrayList.get(index);
    }

    public void add(E element) {
        internalArrayList.add(element);
    }

    public static void main(String[] args) {
        // 用于存放字符串的arrayList 将泛型指定为String
        GenericArrayList<String> stringGenericArrayList = new GenericArrayList<String>();
        // 只能放入String类型元素
        stringGenericArrayList.add("Hello world");
        // 放入其他类型元素会报错
        // stringGenericArrayList.add(1);
        // 取出来也直接是String类型
        String element = stringGenericArrayList.get(0);
        // 用于存放整数的arrayList
        GenericArrayList<Integer> integerGenericArrayList = new GenericArrayList<Integer>();
    }
}
