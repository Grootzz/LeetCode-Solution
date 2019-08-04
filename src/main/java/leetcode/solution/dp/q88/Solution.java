package leetcode.solution.dp.q88;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author noodle
 * @date 2019/8/2 20:48
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0, p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];
        }

        if (p1 < m)
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m - p1 + n - p2);

        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m - p1 + n - p2);
    }


    @Test
    public void doTest() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    @Test
    public void doTest01() {
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int m = 1;
        int[] nums2 = {1, 2, 3, 5, 6};
        int n = 5;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


    @Test
    public void doTest02() {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int m = 5;
        int[] nums2 = {3};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}