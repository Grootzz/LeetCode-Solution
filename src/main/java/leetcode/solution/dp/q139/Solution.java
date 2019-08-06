package leetcode.solution.dp.q139;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 * @author noodle
 * @date 2019/8/6 22:11
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        Set<String> dict = new HashSet<>(wordDict);

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

    @Test
    public void doTest() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }

    @Test
    public void doTest01() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }
}