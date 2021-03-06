package leetcode.solution.string.q3;

import org.junit.Test;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author noodle
 * @date 2019/8/12 20:24
 */
public class Solution {
    public int myAtoi(String str) {

        str = str.trim();

        if (str == null || str.length() == 0)
            return 0;

        boolean isPositive = true;
        int i = 0;

        if (str.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        long res = 0;
        while (i < str.length() && (str.charAt(i) <= '9') && (str.charAt(i) >= '0')) {
            res = res * 10 + str.charAt(i) - '0';
            i++;
            if (res > (long) (Integer.MAX_VALUE)) {
                break;
            }
        }

        res = isPositive ? res : -res;

        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) res;
    }

    @Test
    public void doTest() {
        String str = "42";
        System.out.println(myAtoi(str));
    }

    @Test
    public void doTest01() {
        String str = "4193 with words";
        System.out.println(myAtoi(str));
    }

    @Test
    public void doTest02() {
        String str = "   -42";
        System.out.println(myAtoi(str));
    }

    @Test
    public void doTest03() {
        String str = "words and 987";
        System.out.println(myAtoi(str));
    }

    @Test
    public void doTest04() {
        String str = "-91283472332";
        System.out.println(myAtoi(str));
    }


    @Test
    public void doTest05() {
        String str = "9223372036854775808";
        System.out.println(myAtoi(str));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}