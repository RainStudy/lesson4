package team.redrock.rain.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * team.redrock.rain.io.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/8 下午2:55
 */
public class FileClazz {
    public static void main(String[] args) throws IOException {
        // 根据文件绝对路径实例化一个文件对象 注意：虽然我们实例化了这个文件对象，但是这个路径不一定真的存在这个文件
        File file = new File("D:\\Rain\\file.txt");
        File dir = new File("D:\\Rain");
        // 根据文件在某路径下的相对路径示例化一个文件对象
        File file2 = new File(dir, "file.txt");
        // 如果文件不存在的话
        if (!file.exists()) {
            // 拿到该文件所处目录，如果不存在就创建所有目录
            file.getParentFile().mkdirs();
            // 创建文件
            file.createNewFile();
        }
        // 获得文件对应路径 即 D:\\Rain\\file.txt"
        String path = file.getPath();
        // 该文件对象是否表示的是一个文件目录（文件夹）而非一个文件
        boolean directory = file.isDirectory();
        // 如果这是一个文件目录，则返回一个包含该目录下所有文件的数组，否则返回null
        File[] files = file.listFiles();

        // 删除该文件
        file.delete();
    }
}
