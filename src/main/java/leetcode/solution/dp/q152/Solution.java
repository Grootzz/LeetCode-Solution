package leetcode.solution.dp.q152;

import org.junit.Test;

/**
 * 152. 乘积最大子序列
 *
 * @author noodle
 * @date 2019/8/6 22:35
 */
public class Solution {
    public int maxProduct(int[] nums) {

        int up = 1;
        int down = 1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = up;
                up = down;
                down = tmp;
            }

            up = Math.max(up * nums[i], nums[i]);
            down = Math.min(down * nums[i], nums[i]);

            max = Math.max(max, up);
        }

        return max;
    }

    @Test
    public void doTest() {
        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));
    }

    @Test
    public void doTest01() {
        int[] nums = {-2};

        System.out.println(maxProduct(nums));
    }

    @Test
    public void doTest02() {
        int[] nums = {-4, -3, -2};

        System.out.println(maxProduct(nums));
    }
}