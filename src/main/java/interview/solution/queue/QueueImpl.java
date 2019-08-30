package interview.solution.queue;

/**
 * 链表实现队列
 *
 * @author noodle
 * @date 2019/8/29 22:14
 */
public class QueueImpl<T> {

    /**
     * 定义节点
     */
    private class Node<T> {
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
        }
    }

    private Node front; // 对头
    private Node rear; // 对尾

    public QueueImpl() {
    }

    public T poll() {

        if (rear == null) {
            return null;
        } else {
            Object val = rear.val;
            rear = rear.next;
            return (T) val;
        }

    }

    public void offer(T e) {
        if (front == null) {
            front = new Node(e);
            rear = front;
        } else {
            front.next = new Node(e);
            front = front.next;
        }

    }

}