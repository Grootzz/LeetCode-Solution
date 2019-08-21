package leetcode.solution.string.q43;

import org.junit.Test;

import java.util.Arrays;

/**
 * 43. 字符串相乘
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * @author noodle
 * @date 2019/8/20 14:08
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int n = n1 + n2;
        int[] ans = new int[n];

        for (int i = 0; i < n1; i++) {
            int carry = 0;
            for (int j = 0; j < n2; j++) {
                int mul = (num1.charAt(n1 - 1 - i) - '0') * (num2.charAt(n2 - 1 - j) - '0');
                int sum = mul + ans[n - 1 - i - j] + carry;
                ans[n - 1 - i - j] = sum % 10;
                carry = sum / 10;
            }
            ans[n1 - 1 - i] = carry;
        }

        System.out.println(Arrays.toString(ans));

        StringBuilder sb = new StringBuilder();
        boolean first = false;
        for (int i = 0; i < ans.length; i++) {
            if (!first && ans[i] == 0)
                continue;
            else
                first = true;

            sb.append(ans[i]);
        }

        return sb.toString().length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void doTest() {
        String s1 = "2";
        String s2 = "3";

        System.out.println(multiply(s1, s2));
    }

    @Test
    public void doTest02() {
        String s1 = "123";
        String s2 = "4567";
        System.out.println(123 * 4567);
        System.out.println(multiply(s1, s2));
    }
}