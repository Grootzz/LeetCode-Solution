package leetcode.solution.array.q56;

import org.junit.Test;

import java.util.Arrays;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author noodle
 * @date 2019/8/17 20:49
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return null;

        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        // 指向有效区间的上限
        int k = 0;

        int i = 0;
        int n = intervals.length;
        while (i < n) {
            if (intervals[k][1] < intervals[i][0]) {
                intervals[k][0] = intervals[i][0];
                intervals[k][1] = intervals[i][1];
                k++;
            } else if (intervals[k][1] < intervals[i][1]) {
                intervals[k][1] = intervals[i][1];
                k++;
            }
            i++;
        }

        int[][] res = Arrays.copyOf(intervals, k);

        return res;
    }

    @Test
    public void doTest01() {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] merge = merge(ints);
        for (int[] res : merge) {
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    public void doTest02() {
        int[][] ints = {{1, 4}, {4, 5}};

        int[][] merge = merge(ints);
        for (int[] res : merge) {
            System.out.println(Arrays.toString(res));
        }
    }
}