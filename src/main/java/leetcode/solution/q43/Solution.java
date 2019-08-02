package leetcode.solution.q43;

import java.util.Collections;

/**
 * @author noodle
 * @date 2019/7/9 19:24
 */
public class Solution {

    public static void main(String[] args) {
        String nums1 = "123";
        String nums2 = "456";
        System.out.println(new Solution().multiply(nums1, nums2));
    }

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int n = n1 + n2;
        char[] ans = new char[n];

        for (int i = 0; i < n2; i++) {
            int carry = 0;
            for (int j = 0; j < n1; j++) {
                int sum = (num2.charAt(n2 - 1 - i) - '0') * (num1.charAt(n1 - j - 1) - '0');
                ans[n - 1 - i - j] = (char) (ans[n - 1 - i - j] + sum + carry);
            }
        }

        return "";
    }


}
