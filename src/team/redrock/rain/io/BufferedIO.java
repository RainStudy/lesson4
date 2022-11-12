package team.redrock.rain.io;

import java.io.*;

/**
 * team.redrock.rain.io.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/10 上午12:52
 */
public class BufferedIO implements IOExample {

    public final static BufferedIO INSTANCE = new BufferedIO();

    private final File file = new File("/home/rain/Rain/hello.txt");

    public static void main(String[] args) {

    }

    @Override
    public void useInputStream() throws IOException {
        // 只要new一个BufferedStream，把其他stream作为参数传入就可以让这个流带缓冲啦
        // 第二个参数是缓冲区大小，默认就是8192，也就是8kb
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file), 8192)) {
            // 用法还是差不离的
            byte[] bytes = new byte[inputStream.available()];
            int len = 0;
            int temp;
            // 区别就在这里，它第一次read的时候实际上并不是只读取了一个字节，而是请求了缓冲区对应大小的字节数量
            // 然后之后的读取都是从缓冲区中读取，从缓冲区中读取的速度是非常快的，因为不需要请求系统调用，只需要读内存
            // 直到缓冲区空了之后再次请求系统调用来填满缓冲区
            // 如果没有缓冲区，我们的每一次读取都需要进行系统调用，而等待系统调用返回的时间是比较长的
            // 带缓冲区的流的读写减少了系统调用的数量，因此性能更好
            while ((temp = inputStream.read()) != -1) {
                bytes[len++] = (byte) temp;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useOutputStream() throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            // 为了解释缓冲的过程，我这边将字符串转成字节数组，一个一个写入缓冲流
            byte[] bytes = "Hello redrock!".getBytes();
            for (byte b : bytes) {
                // 我们这里一个一个写字节，实际上只是写入了缓冲区，
                // 缓冲区满或手动调用flush()方法时才会将缓冲区中的字节一次性写入文件
                outputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 我们不需要手动调用flush()，因为在关流时底层会自动清空缓冲区并写入文件
    }

    @Override
    public void useReader() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            int temp;
            while ((temp = reader.read()) != -1) {
                stringBuilder.append((char) temp);
            }
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void useWriter() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Hello redrock!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
