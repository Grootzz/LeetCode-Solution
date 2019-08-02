package leetcode.solution.heap.q313;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/super-ugly-number/
 *
 * @author noodle
 * @date 2019/7/31 15:32
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];

        int[] p = new int[primes.length];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            int min = primes[0] * dp[p[0]];
            for (int j = 1; j < p.length; j++)
                if (min > primes[j] * dp[p[j]])
                    min = primes[j] * dp[p[j]];

            for (int j = 0; j < p.length; j++)
                if (min == primes[j] * dp[p[j]])
                    p[j]++;

            dp[i] = min;
        }

        return dp[dp.length - 1];
    }

    @Test
    public void case01() {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(n, primes));
    }
}