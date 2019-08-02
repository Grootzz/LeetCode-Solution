package leetcode.solution.q75;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 *
 * @author noodle
 * @date 2019/7/24 20:57
 */
public class Solution {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        // 指向0的最右
        int p0 = 0;
        // 指向2的最左
        int p2 = nums.length - 1;
        int cur = 0;

        while (cur <= p2) {
            if (nums[cur] == 0) {
                swap(nums, cur, p0);
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, p2);
                p2--;
                //cur++;
            } else {
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void case01() {
        int[] nums = {0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void case02() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void case03() {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void case04() {
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
