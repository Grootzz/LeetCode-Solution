package leetcode.solution.heap.extra;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author noodle
 * @date 2019/7/29 19:57
 */
public class CustomedPriorityQueue {

    private int size = 0;
    // 当前队列中的元素个数
    private int curSize = 0;
    private int[] queue = new int[10];

    /**
     * insert element
     *
     * @param e
     */
    public void insert(int e) {
        if (curSize == queue.length)
            queue = Arrays.copyOf(queue, queue.length * 2 + 1);

        int hole = curSize++;
        for (; hole > 0 && (e < queue[(hole - 1) / 2]); hole = (hole - 1) / 2)
            queue[hole] = queue[(hole - 1) / 2];

        queue[hole] = e;
    }

    /**
     * 删除最小元素
     */
    public void deleteMin() {
        if (curSize == queue.length)
            return;

        int child = 0;
        int lastE = queue[curSize - 1];
        int hole = 0;
        for (; (hole * 2 + 1) < curSize; hole = child) {
            child = hole * 2 + 1;// 指向左孩子
            if (child + 1 < curSize && queue[child] > queue[child + 1])
                child++;// 指向右孩子
            if (lastE > queue[child])
                queue[hole] = queue[child];
            else
                break;
        }

        queue[hole] = lastE;
        queue[curSize - 1] = 0;
        curSize--;
    }


    /**
     * 1. 构建 max 堆
     * 2. 将堆顶元素与最后一个元素交换
     * 3. 重复1,2
     *
     * @param nums
     */
    public void heapSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        // build max heap
        for (int i = (nums.length - 2) / 2 + 1; i >= 0; i--) {
            adjust(nums, i, nums.length);
        }

        // sort
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjust(nums, 0, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 调整堆，每次找出最大值放在 hole 处
     */
    private void adjust(int[] nums, int hole, int end) {
        int tmp = nums[hole];
        int child = 0;
        for (; hole * 2 + 1 < end; hole = child) {
            // 指向左孩子
            child = hole * 2 + 1;
            if (child + 1 < end && nums[child] < nums[child + 1])
                child++;// 指向右孩子
            if (nums[child] > tmp)
                nums[hole] = nums[child];
            else
                break;
        }

        nums[hole] = tmp;
    }

    @Test
    public void insertTest() {
        insert(13);
        insert(14);
        insert(16);
        insert(19);
        insert(21);
        insert(19);
        insert(68);
        insert(65);
        insert(26);
        insert(32);
        insert(31);
        System.out.println(Arrays.toString(queue));
    }

    @Test
    public void testDeleteMin() {
        insertTest();
        deleteMin();
        System.out.println(Arrays.toString(queue));
    }

    @Test
    public void testHeapSort() {
        int[] nums = {5, 3, 4, 1, 2, 6, 9, 8, 7, 11, 23, 45, 32, 2};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}