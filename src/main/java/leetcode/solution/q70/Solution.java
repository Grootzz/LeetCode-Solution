package leetcode.solution.q70;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author noodle
 * @date 2019/7/22 20:58
 */
public class Solution {
    public static void main(String[] args) {

        System.out.println(new Solution().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n < 3)
            return n;

        int step1 = 2;
        int step2 = 1;
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = step1 + step2;
            step2 = step1;
            step1 = res;
        }

        return res;
    }
}
