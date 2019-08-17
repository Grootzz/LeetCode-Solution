package interview.solution.prob;

import org.junit.Test;

/**
 * 有一个随机函数 rand_0_and_1_with_p(), 这个随机数生成器，它能够以概率 p 产生0，以概率 (1-p) 产生1。
 * 使用这个随机函数，设计一个新的随机函数要求以等概率生成0和1。
 * <p>
 * 生成零的概率是 p ,1的概率是 (1-p) ,那么两个数随机数,第一个为0第二个为1的概率为 p(1-p) ,
 * 第一个为1第二个为0的概率为 (1-p)p 。从而实现等概率。
 *
 * @author noodle
 * @date 2019/8/13 22:12
 */
public class Prob {

    private double p = 0.2;

    public int rand_0_and_1_with_equal_prob() {
        int rand1 = rand_0_and_1_with_p();
        int rand2 = rand_0_and_1_with_p();

        if (rand1 == 0 && rand2 == 1) {
            return 0;
        } else if (rand1 == 1 && rand2 == 0) {
            return 1;
        } else {
            return rand_0_and_1_with_equal_prob();
        }
    }

    public int rand_0_and_1_with_p() {
        return Math.random() > p ? 1 : 0;
    }

    @Test
    public void doTest() {
        System.out.println(rand_0_and_1_with_equal_prob());
    }
}