package common.algo.sort;

import org.junit.Test;

import java.util.Arrays;

import static util.ArrayUtils.swap;

/**
 * 堆排序是不稳定排序。 最坏，最好，平均时间复杂度均为O(nlogn)
 *
 * @author noodle
 * @date 2019/7/30 09:01
 */
public class HeapSort {

    /**
     * heap sort
     *
     * @param nums
     */
    public void heapSort(int[] nums) {

        buildHeap(nums);

        for (int n = nums.length - 1; n > 0; n--) {
            swap(nums, 0, n);
            downRoot(nums, 0, n);
        }

    }

    /**
     * 下滤root到合适的位置，使以root节点开始的子树满足 (nums[i] > nums[2*i+1]) && (nums[i] > nums[2*i+2])
     * 将root当做最大值进行删除(放到一个合适的位置，使子树满足上面的条件)
     *
     * @param nums
     * @param hole sub-tree root
     * @param n
     */
    private void downRoot(int[] nums, int hole, int n) {
        int tmp = nums[hole];
        int child = 0;
        // down root
        for (; (2 * hole + 1) < n; hole = child) {
            child = 2 * hole + 1; // point to left child node
            if (child + 1 < n && nums[child] < nums[child + 1])
                child++; // point to right child node
            if (tmp < nums[child])
                nums[hole] = nums[child];
            else
                break;
        }

        nums[hole] = tmp;
    }

    /**
     * 构建堆
     *
     * @param nums
     */
    private void buildHeap(int[] nums) {
        for (int hole = nums.length / 2 - 1; hole >= 0; hole--)
            downRoot(nums, hole, nums.length);
    }

    @Test
    public void testHeapSort() {
        int[] nums = {150, 80, 40, 30, 10, 70, 110, 100, 20, 90, 60, 50, 120, 140, 130};
        heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }

}