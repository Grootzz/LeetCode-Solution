package leetcode.solution.backtrace.q93;
/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author noodle
 * @date 2019/8/20 11:01
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12)
            return ans;
        Stack<String> stack = new Stack<>();

        backtrace(ans, stack, s, 0);

        return ans;
    }

    private void backtrace(List<String> ans, Stack<String> stack, String s, int curLen) {
        if (curLen == s.length() && stack.size() == 4) {
            String ip = stack.toString().substring(1, stack.toString().length() - 1).replace(", ", ".");
            ans.add(ip);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if ((curLen + i) > s.length())
                break;

            String part = s.substring(curLen, curLen + i);
            if ((part.length() == 2 && part.charAt(0) == '0') || (part.length() == 3 && part.charAt(0) == '0'))
                break;

            int num = Integer.parseInt(part);

            if (num <= 255) {
                stack.push("" + num);
                backtrace(ans, stack, s, curLen + i);
                stack.pop();
            } else {
                break;
            }
        }
    }


    @Test
    public void doTest() {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }


    @Test
    public void doTest01() {
        String s = "010010";
        System.out.println(restoreIpAddresses(s));
    }
}