package leetcode.solution.backtrace.q17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author noodle
 * @date 2019/8/18 09:49
 */
public class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<String> ans = new ArrayList<>();
        backtrace(map, ans, "", digits);

        return ans;
    }

    private void backtrace(Map<Character, char[]> map, List<String> ans, String subStr, String subDigits) {
        if (subDigits.length() == 0) {
            ans.add(subStr);
        } else {
            char c = subDigits.charAt(0);
            char[] letters = map.get(c);

            for (int i = 0; i < letters.length; i++) {
                backtrace(map, ans, subStr + letters[i], subDigits.substring(1));
            }
        }
    }

    @Test
    public void doTest() {
        String digs = "23";
        List<String> ans = letterCombinations(digs);
        System.out.println(ans);
    }
}