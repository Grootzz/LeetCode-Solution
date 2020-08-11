package leetcode.solution.array.q1343;

import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/">1343. 大小为 K 且平均值大于等于阈值的子数组数目</a>
 *
 * @author noodle
 * @date 2020/8/11 20:16
 */
public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr == null || arr.length == 0)
            return -1;

        int ans = 0;
        int subsum = 0;
        int th = threshold * k;

        for (int i = 0; i < k; i++) {
            subsum += arr[i];
        }

        if (subsum >= th) {
            ans = ans + 1;
        }

        for (int i = k; i < arr.length; i++) {
            subsum = subsum - arr[i - k] + arr[i];
            if (subsum >= th) {
                ans = ans + 1;
            }
        }

        return ans;
    }

    @Test
    public void case_01() {
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3, threshold = 4;

        System.out.println(numOfSubarrays(arr, k, threshold));
    }


    @Test
    public void case_02() {
        int[] arr = {1, 1, 1, 1, 1};
        int k = 1, threshold = 0;

        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}
