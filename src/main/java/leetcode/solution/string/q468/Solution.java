package leetcode.solution.string.q468;

import org.junit.Test;

/**
 * 468. 验证IP地址
 * https://leetcode-cn.com/problems/validate-ip-address/
 *
 * @author noodle
 * @date 2019/9/19 21:29
 */
public class Solution {
    public String validIPAddress(String IP) {
        if (IP.startsWith(":") || IP.startsWith(".") || IP.endsWith(":") || IP.endsWith("."))
            return "Neither";

        String[] v4Split = IP.split("\\.");
        if (v4Split.length == 4) {

            int part = -1;
            for (int i = 0; i < v4Split.length; i++) {
                try {
                    part = Integer.valueOf(v4Split[i]);
                } catch (Exception e) {
                    return "Neither";
                }

                if (part > 255 || part < 0)
                    return "Neither";

                if (v4Split[i].length() > 1 && (v4Split[i].startsWith("0") || v4Split[i].startsWith("-")))
                    return "Neither";
            }

            return "IPv4";
        } else {
            String[] v6split = IP.split(":");

            if (v6split.length == 8) {
                int part = -1;

                for (int i = 0; i < v6split.length; i++) {

                    int len = v6split[i].length();

                    if (v6split[i] == null || len == 0 || len > 4)
                        return "Neither";

                    for (int j = 0; j < len; j++) {
                        char c = v6split[i].charAt(j);

                        if (!((c >= '0' && c <= '9')
                                || (c >= 'a' && c <= 'f')
                                || (c >= 'A' && c <= 'F')))
                            return "Neither";
                    }
                }

                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }


    @Test
    public void doTest() {
        String IP = "172.16.254.1";
        System.out.println(validIPAddress(IP));
    }

    @Test
    public void doTest02() {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(validIPAddress(IP));
    }

    @Test
    public void doTest03() {
        String IP = "256.256.256.256";
        System.out.println(validIPAddress(IP));
    }
}