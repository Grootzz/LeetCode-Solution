package leetcode.solution.bit.q402;

import org.junit.Test;

import java.util.Stack;

/**
 * 402. 移掉K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 *
 * @author noodle
 * @date 2019/8/30 15:58
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        if (k != 0) {

        }

        StringBuilder sb = new StringBuilder();

        int len = stack.size();
        for (int i = 0; i < len - 1; i++) {
            sb.append(stack.pop());
        }

        if (stack.peek() != '0')
            sb.append(stack.pop());
        else if (len == 1)
            sb.append(stack.pop());

        return sb.reverse().toString();
    }

    @Test
    public void doTest() {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }

    @Test
    public void doTest01() {
        String num = "10200";
        int k = 1;

        System.out.println(removeKdigits(num, k));
    }

    @Test
    public void doTest02() {
        String num = "10";
        int k = 2;

        System.out.println(removeKdigits(num, k));
    }

    @Test
    public void doTest03() {
        String num = "10";
        int k = 1;

        System.out.println(removeKdigits(num, k));
    }

    @Test
    public void doTest04() {
        String num = "112";
        int k = 1;

        System.out.println(removeKdigits(num, k));
    }
}