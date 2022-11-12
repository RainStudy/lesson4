package team.redrock.rain.io;

import java.io.*;
import java.nio.CharBuffer;

/**
 * team.redrock.rain.io.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/8 下午4:45
 */
public class FileIO implements IOExample {

    public final static FileIO INSTANCE = new FileIO();

    private final File file = new File("/home/rain/Rain/hello.txt");

    public static void main(String[] args) throws IOException {
        INSTANCE.useWriter();
    }

    @Override
    public void useInputStream() throws IOException {
        // 使用文件字节流读取文件内容 既然是读取，从程序的角度来看就是读入内存，那就应该使用inputStream
        // 既然是字节流，肯定要一个字节一个字节的读咯
        // 使用字节流的好处是无论是二进制文件还是纯文本文件都可以读取，但坏处是必须要以字节为单位读，比较麻烦
        FileInputStream fileInputStream = new FileInputStream(file);
        // 估计此流中可以读出来字节的数量，注意，该值不一定是文件的实际大小
        int available = fileInputStream.available();
        byte[] bytes = new byte[available];
        // 一个一个字节读
        int temp;
        int len = 0;
        // read返回-1的时候就说明文件读完了，退出循环
        while ((temp = fileInputStream.read()) != -1) {
            bytes[len++] = (byte) temp;
        }
        // 或者直接用这个方法一次性读到数组里面
        int readCounts = fileInputStream.read(bytes);
        // 读完后把字节数组转成字符串后输出
        System.out.println(new String(bytes));
        // 使用I/O流可要养成随手关流的好习惯
        fileInputStream.close();
    }

    @Override
    public void useOutputStream() throws IOException {
        // 使用文件字节流将字符串写入文件 既然是写入，那就是相对于程序输出，那就应该使用outputStream
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("REDROCK MOBILE".getBytes());
        // 记得关流
        fileOutputStream.close();
    }

    @Override
    public void useReader() {
        try (FileReader fileReader = new FileReader(file)) {
            StringBuilder str = new StringBuilder();
            int temp;
            // 好吧，好像也没简单多少，就是读出来是char可以直接加到string上面罢了
            while ((temp = fileReader.read()) != -1) {
                str.append((char) temp);
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useWriter() {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("Android Development");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
