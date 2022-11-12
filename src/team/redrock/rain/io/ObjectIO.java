package team.redrock.rain.io;

import java.io.*;

/**
 * team.redrock.rain.io.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/10 下午10:31
 */
public class ObjectIO implements IOExample {

    public static final ObjectIO INSTANCE = new ObjectIO();
    private final File file = new File("/home/rain/Rain/hello.txt");

    public static void main(String[] args) {

    }

    @Override
    public void useInputStream() throws IOException {
        // 从文件中读取对象
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            Person person = (Person)inputStream.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useOutputStream() throws IOException {
        // 将对象写入文件
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(new Person(19, "艾姐姐"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useReader() throws IOException {

    }

    @Override
    public void useWriter() throws IOException {

    }
}

// 实现了Serializable接口
class Person implements Serializable {
    private final int age;
    private final String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
