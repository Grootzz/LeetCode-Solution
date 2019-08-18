package leetcode.solution.backtrace.q17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 回溯+剪枝
 *
 * @author noodle
 * @date 2019/8/18 09:49
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrace(List<String> ans, String sub, int open, int close, int n) {
        if (sub.length() == 2 * n) {
            ans.add(sub);
            return;
        }

        if (open < n)
            backtrace(ans, sub + "(", open + 1, close, n);

        if (close < open)
            backtrace(ans, sub + ")", open, close + 1, n);

    }

    @Test
    public void doTest() {
        List<String> ans = generateParenthesis(3);
        System.out.println(ans);
    }
}