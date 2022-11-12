package team.redrock.rain.collection;

import java.util.*;

/**
 * team.redrock.rain.collection.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/5 上午12:21
 */
public class CollectionTest {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        // 使用put方法放入键值对
        hashMap.put("红岩网校", "RedRock");
        hashMap.put("安卓开发", "Android development");
        // 使用get方法根据键得到值
        String redrockEnglish = hashMap.get("红岩网校");
        // 获得一个包含所有键值对的Set
        // Map.Entry存储单独的键值对，可以通过它获得键和对应的值
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 获取一个包含所有键的Set
        Set<String> keySet = hashMap.keySet();
        // 获取一个包含所有值的集合
        Collection<String> values = hashMap.values();
    }
}
