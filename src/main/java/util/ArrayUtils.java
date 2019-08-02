package util;

/**
 * @author noodle
 * @date 2019/7/30 09:29
 */
public class ArrayUtils {

    /**
     * 交换数组中的两个元素
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}