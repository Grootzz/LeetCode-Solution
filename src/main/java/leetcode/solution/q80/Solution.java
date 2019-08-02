package leetcode.solution.q80;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author noodle
 * @date 2019/7/26 22:18
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int k = 0;
        for (int n : nums) {
            if (k < 2 || nums[k-2] != n) {
                nums[k] = n;
                k++;
            }
        }

        return k;
    }

    @Test
    public void case01() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void case02() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
