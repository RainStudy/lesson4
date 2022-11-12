package team.redrock.rain.generics;

import java.util.ArrayList;

/**
 * team.redrock.rain.generics.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/3 下午9:30
 */
public class IntArrayList {
    private ArrayList internalArrayList = new ArrayList();

    public int getInt(int index) {
        return (int) internalArrayList.get(index);
    }

    public void addInt(int index) {
        internalArrayList.add(index);
    }
}
