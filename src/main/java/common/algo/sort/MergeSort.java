package common.algo.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * merge sort
 * 归并排序是稳定排序。归并排序的最好，最坏，平均时间复杂度均为O(nlogn)
 * thinking of divide & conquer
 *
 * @author noodle
 * @date 2019/8/1 10:25
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int[] tmp = new int[nums.length];
        mergeSort(nums, tmp, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;

        mergeSort(nums, tmp, left, mid);
        mergeSort(nums, tmp, mid + 1, right);
        merge(nums, tmp, left, mid, right);
    }

    private void merge(int[] nums, int[] tmp, int left, int mid, int right) {
        int i = left; // point left sorted array
        int j = mid + 1;// point right sorted array
        int n = 0; // point tmp first

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j])
                tmp[n++] = nums[i++];
            else
                tmp[n++] = nums[j++];
        }

        while (i <= mid)
            tmp[n++] = nums[i++];

        while (j <= right)
            tmp[n++] = nums[j++];

        n = 0;
        while (left <= right) {
            nums[left++] = tmp[n++];
        }
    }


    @Test
    public void case01() {
        int[] nums = {2, 1, 4, 5, 0, 3, 9, 8, 7, 6};
        mergeSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void case02() {
        int[] nums = {2, 2, 4, 5, 0, 0, 9, 9, 9, 6};
        mergeSort(nums);

        System.out.println(Arrays.toString(nums));
    }

}