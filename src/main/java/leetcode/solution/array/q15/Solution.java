package leetcode.solution.array.q15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author noodle
 * @date 2019/8/1 15:01
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > 0)
                break;
            // 去重
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                int sum = nums[m] + nums[n];
                if (sum == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    while (m < n && nums[m] == nums[++m]) ;
                    while (m < n && nums[n] == nums[--n]) ;
                } else if (sum < -nums[i])
                    m++;
                else
                    n--;
            }
        }
        return res;
    }

    @Test
    public void case01() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

}