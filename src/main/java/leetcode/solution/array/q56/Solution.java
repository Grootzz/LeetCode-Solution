package leetcode.solution.array.q56;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author noodle
 * @date 2019/8/17 20:49
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();

        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            while (i + 1 < n && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }

        return res.toArray(new int[res.size()][2]);
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

    @Test
    public void doTest03() {
        int[][] ints = {{1, 4}, {1, 4}};

        int[][] merge = merge(ints);
        for (int[] res : merge) {
            System.out.println(Arrays.toString(res));
        }
    }

    @Test
    public void doTest04() {
        int[][] ints = {{1, 4}, {5, 6}};

        int[][] merge = merge(ints);
        for (int[] res : merge) {
            System.out.println(Arrays.toString(res));
        }
    }
}