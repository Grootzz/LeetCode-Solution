package leetcode.solution.array.q1013;

/**
 * 1013. 将数组分成和相等的三个部分
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * @author noodle
 * @date 2019/8/30 22:47
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {

        if (A == null || A.length < 3)
            return false;

        int sum = 0;
        for (int a : A) {
            sum += a;
        }

        if (sum % 3 != 0)
            return false;

        int avg = sum / 3;

        int sumTmp = 0;
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            sumTmp += A[i];
            if (avg == sumTmp) {
                cnt++;
                sumTmp = 0;
            }
        }

        return cnt == 3;
    }
}