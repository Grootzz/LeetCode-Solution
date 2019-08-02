package leetcode.solution.q41;

/**
 * @author noodle
 * @date 2019/7/8 20:29
 */
class Solution {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        System.out.println(new Solution().firstMissingPositive(nums));

    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && (nums[i] != nums[nums[i] - 1]))
                swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j])
            return;

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
