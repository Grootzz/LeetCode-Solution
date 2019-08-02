package leetcode.solution.q56;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * @author noodle
 * @date 2019/7/10 22:07
 */
public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] merge = new Solution().merge(nums);

        for (int[] ints : merge) {
            System.out.println(ints);
        }
    }

    public int[][] merge(int[][] intervals) {


        return null;
    }
}
