package leetcode.solution.array.q1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author noodle
 * @date 2019/8/1 14:43
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub) && map.get(sub) != i)
                return new int[]{i, map.get(sub)};
        }

        return null;
    }

}