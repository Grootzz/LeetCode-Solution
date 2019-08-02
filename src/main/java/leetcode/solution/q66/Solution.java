package leetcode.solution.q66;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/
 *
 * @author noodle
 * @date 2019/7/22 20:58
 */
public class Solution {
    public static void main(String[] args) {

        int[] digits = {1, 2, 9};
        System.out.println(Arrays.toString(new Solution().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }

        return digits;
    }
}
