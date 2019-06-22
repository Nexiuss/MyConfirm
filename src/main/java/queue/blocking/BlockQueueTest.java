/**
 * FileName: BlockQueueTest
 * Author:   Administrator
 * Date:     2019/5/29 11:30
 * Description:
 */
package queue.blocking;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockQueueTest {

    static LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        blockingQueue.offer("0");
        blockingQueue.offer("1");
        blockingQueue.offer("2");
        blockingQueue.offer("3");
        blockingQueue.offer("4");
        blockingQueue.offer("5");
        blockingQueue.offer("6");
        blockingQueue.offer("7");
        blockingQueue.offer("8");

        List<String> list = new ArrayList<>();
        int i = blockingQueue.drainTo(list, 10);
        int i2 = blockingQueue.drainTo(list, 10);

        String peek = blockingQueue.take();

        System.out.println(i);
        System.out.println(i2);
    }
}
