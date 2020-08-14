package leetcode.solution.array.interviewquestion.others.q1;

import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/">剑指 Offer 53 - II. 0～n-1中缺失的数字<a/>
 *
 * @author noodle
 * @date 2020/8/14 21:16
 */
public class Solution {
    public int missingNumber(int[] nums) {

        if ((nums[0] == 1)) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    @Test
    public void case_01() {
        int[] ints = {0, 1, 3};
        System.out.println(missingNumber(ints));
    }

    @Test
    public void case_02() {
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(missingNumber(ints));
    }
}
