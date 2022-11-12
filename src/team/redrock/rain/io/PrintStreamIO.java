package team.redrock.rain.io;

import java.io.*;
import java.util.Scanner;

/**
 * team.redrock.rain.io.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/10 下午9:22
 */
public class PrintStreamIO implements IOExample {

    public static final PrintStreamIO INSTANCE = new PrintStreamIO();

    private final File file = new File("/home/rain/Rain/hello.txt");

    public static void main(String[] args) {

    }

    @Override
    public void useInputStream() throws IOException {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            // 读文件就这样一行行的读 轻松愉快
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useOutputStream() throws IOException {
        try (PrintStream printStream = new PrintStream(new FileOutputStream(file))) {
            System.out.println();
            // 于是我们就可以像System.out.println一样向文件中打印字符了
            printStream.println("Hello Redrock!");
            // 各种基本类型也是支持的，并且只要是重写了toString()方法的类的对象都是支持的
            printStream.println(1);
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
