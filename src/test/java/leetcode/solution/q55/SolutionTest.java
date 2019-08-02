package leetcode.solution.q55;

public class SolutionTest {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};// true
        //int[] nums = {3,2,1,0,4};// false

        System.out.println(new SolutionTest().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int last = n;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] + i >= last)
                last = i;
        }

        return last == 0;
    }
}
