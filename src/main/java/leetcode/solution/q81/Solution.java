package leetcode.solution.q81;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author noodle
 * @date 2019/7/26 22:18
 */
public class Solution {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int mid = 0;
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            mid = (L + R) / 2;

            if (nums[L] < nums[mid]) {
                if (nums[L] <= target && target <= nums[mid]) {
                    R = mid;
                } else {
                    L = mid + 1;
                }
            } else if (nums[L] > nums[mid]) {
                if (nums[mid] < target && target <= nums[R]) {
                    L = mid + 1;
                } else {
                    R = mid;
                }
            } else {
                if (nums[L] == target)
                    return true;
                else
                    L++;
            }
        }

        return nums[L] == target;
    }

    @Test
    public void case01() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    @Test
    public void case02() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int target = 3;
        System.out.println(search(nums, target));
    }

}
