package team.redrock.rain.collection;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * team.redrock.rain.collection.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/6 下午2:58
 */
public class IteratorTest {
    public static void main(String[] args) {
        ListIterator<Integer> integerListIterator = List.of(1, 2, 3, 4).listIterator();
        // 正序遍历
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }
        // 反序遍历
        while (integerListIterator.hasPrevious()) {
            System.out.println(integerListIterator.previous());
        }
        
    }
}
