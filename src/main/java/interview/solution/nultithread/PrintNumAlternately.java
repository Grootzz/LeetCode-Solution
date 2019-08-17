package interview.solution.nultithread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数字 0-9，线程 A 先打印，打印到 5 之后，线程 B 接着打印
 *
 * @author noodle
 * @date 2019/8/17 19:01
 */
public class PrintNumAlternately {

    /**
     * 使用线程嵌套
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            final int[] i = {0};
            while (i[0] < 5)
                System.out.println(Thread.currentThread().getName() + ": " + i[0]++);

            new Thread(() -> {
                while (i[0] < 10)
                    System.out.println(Thread.currentThread().getName() + ": " + i[0]++);
            }).start();
        }).start();
    }

    /**
     * 第二种方法
     */
    private volatile boolean preFinish = false;
    private int num = 0;
    private Object lock = new Object();

    public void m2() {
        new Thread(() -> {
            synchronized (lock) {
                while (num < 5) {
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                }
                preFinish = true;
                lock.notifyAll();
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                while (!preFinish) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                while (num < 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                }
            }
        }).start();
    }

    @Test
    public void m2Test() {
        m2();
    }

    /**
     * 第三种方法
     */
    public void m3() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        final int[] num = {0};

        new Thread(() -> {
            lock.lock();
            while (num[0] < 5)
                System.out.println(Thread.currentThread().getName() + ": " + num[0]++);

            condition.signalAll();

            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();

            while (num[0] != 5) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (num[0] < 10)
                System.out.println(Thread.currentThread().getName() + ": " + num[0]++);

            lock.unlock();
        }).start();
    }

    @Test
    public void m3Test(){
        m3();
    }
}