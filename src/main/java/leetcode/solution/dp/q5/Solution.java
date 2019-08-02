package leetcode.solution.dp.q5;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 中心扩散
 *
 * @author noodle
 * @date 2019/8/1 21:33
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int left = 0; // point max-palindrome left
        int right = 0;// point max-palindrome right

        for (int i = 0; i < s.length(); i++) {
            int palindromeOddLen = mirror(s, i, i);
            int palindromeEvenLen = mirror(s, i, i + 1);
            int palindromeLen = Math.max(palindromeOddLen, palindromeEvenLen);

            // make left&right to pointing palindrome
            if (palindromeLen > right - left) {
                left = i - ((palindromeLen - 1) >> 1);
                right = i + (palindromeLen >> 1);
            }
        }

        return s.substring(left, right + 1);
    }

    private int mirror(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    @Test
    public void case01() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}