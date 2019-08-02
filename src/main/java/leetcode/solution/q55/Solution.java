package leetcode.solution.q55;

public class Solution {
    /**
     * 从后往前遍历，起始边界为最后一个元素的位置，
     * 如果当前元素能跳到边界位置，则将边界位置更新到当前元素处
     * 若更新的边界位置最后为0，则意味着该数组可以跳到最后
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int last = n;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= last - i)
                last = i;
        }
        return last == 0;
    }
}
