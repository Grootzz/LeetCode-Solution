package interview.solution.blockingqueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Java实现阻塞队列：
 * 阻塞队列是生产者消费者模型的具体体现
 * put()操作时，如果队列满了，则执行put()操作的线程阻塞。take()操作时，如果队列为空，则执行take()操作的线程也会阻塞
 * <p>
 * 考点：为什么使用while, 而不是用if
 * 考虑put操作，如果在实例化BlockingQueue后，在代码某处当 size==limit 时调用notify，如果使用if，则会造成线程在size==limit被唤醒
 * 从而add元素到队列，就不能维持size<=limit的关系了
 * take操作时同理
 *
 * @author noodle
 * @date 2019/8/2 18:35
 */
public class BlockingQueue<T> {
    private List<T> queue;
    private int limit = 0;

    public BlockingQueue() {
        this(10);
    }

    public BlockingQueue(int limit) {
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(T e) throws InterruptedException {
        // 队列满时阻塞线程
        while (queue.size() == limit)
            wait();

        // 如果队列为空时，唤醒所有执行take()操作时阻塞的线程
        if (queue.size() == 0)
            notifyAll();

        queue.add(e);
    }

    public synchronized T take() throws InterruptedException {
        while (queue.size() == 0)
            wait();

        // 队列即将移除原始，唤醒所有等待插入元素的队列
        if (queue.size() == limit)
            notifyAll();

        return queue.remove(0);
    }

    /**
     * test
     */
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new BlockingQueue<>();

        // 100 个 producer 生产
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    String msg = "Producer: " + Thread.currentThread();
                    System.out.println(msg);
                    blockingQueue.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 100 个 consumer 获取
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    String msg = blockingQueue.take();
                    System.out.println("Consumer---->" + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}