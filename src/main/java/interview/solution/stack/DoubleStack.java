package interview.solution.stack;

/**
 * 一个数组实现两个栈
 *
 * @author noodle
 * @date 2019/8/30 09:23
 */
public class DoubleStack<T> {

    private T[] elements;

    private int top1;
    private int top2;

    private int size;

    public DoubleStack() {
        this.elements = (T[]) new Object[10];
    }

    public boolean push1(T e) {
        if (top1 + 1 == top2) {
            return false;
        } else {
            elements[top1 + 1] = e;
            return true;
        }
    }

    public boolean push2(T e) {
        if (top1 == top2 - 1) {
            return false;
        } else {
            elements[top2 - 1] = e;
            return true;
        }
    }

    public T pop1(T e) {
        if (top1 == -1) {
            return null;
        } else {
            return elements[top1--];
        }
    }

    public T pop2(T e) {
        if (top2 == -1) {
            return null;
        } else {
            return elements[top2--];
        }
    }
}