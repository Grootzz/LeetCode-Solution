package leetcode.solution.divideconquer.q4;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author noodle
 * @date 2019/8/1 11:10
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] tmp = new int[n1 + n2];
        int i = 0, j = 0;
        int n = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j])
                tmp[n++] = nums1[i++];
            else
                tmp[n++] = nums2[j++];
        }

        while (i < n1)
            tmp[n++] = nums1[i++];

        while (j < n2)
            tmp[n++] = nums2[j++];

        double res = 0;
        if ((tmp.length & 1) == 0)
            res = (double) (tmp[(tmp.length >> 1) - 1] + tmp[tmp.length >> 1]) / 2;
        else
            res = (double) tmp[tmp.length >> 1];

        return res;
    }

    @Test
    public void case01() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}