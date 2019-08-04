package leetcode.solution.dp.q89;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/gray-code/
 *
 * @author noodle
 * @date 2019/8/2 22:10
 */
public class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(0);

        for (int i = 0; i < n; i++) {
            int mir = 1 << i;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + mir);
            }
        }

        return res;
    }


    @Test
    public void doTest01() {
        System.out.println(grayCode(2));
    }

    @Test
    public void doTest02(){
        System.out.println(grayCode(3));
    }
}