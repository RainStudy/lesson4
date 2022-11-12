package team.redrock.rain.async;

import java.util.ArrayList;
import java.util.List;

/**
 * team.redrock.rain.async.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/12 上午12:46
 */
public class Async {

    // 用于存放任务的任务队列
    static List<Task> queue = new ArrayList<>();

    public static void main(String[] args) {
        // 将第一个任务添加到队列中
        submitTask(Async::start);
        // 任务队列中不为空
        while (!queue.isEmpty()) {
            // 取出队列头部的任务
            Task task = queue.remove(0);
            // 执行任务
            task.runTask();
        }
    }

    // 这里是用户逻辑的真正入口，它将作为队列的第一个任务执行
    // 如果在这个任务中我们没有submitTask，那它执行完毕后程序就会退出
    // 如果在这其中submitTask了，那么执行完这个任务后会接着执行下一个任务
    static void start() {
        System.out.println(1);
        submitTask(() -> System.out.println(2));
        System.out.println(3);
        submitTask(() -> System.out.println(4));
    }

    // 将一个任务添加到任务队列尾部
    static void submitTask(Task task) {
        queue.add(task);
    }
}

// 表示单个任务的函数式接口
@FunctionalInterface
interface Task {
    void runTask();
}
