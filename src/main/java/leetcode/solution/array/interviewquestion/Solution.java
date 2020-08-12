package leetcode.solution.array.interviewquestion;

import org.junit.Test;

/**
 * <a href="https://leetcode-cn.com/problems/tic-tac-toe-lcci/">面试题 16.04. 井字游戏</a>
 *
 * @author noodle
 * @date 2020/8/12 19:35
 */
public class Solution {
    public String tictactoe(String[] board) {

        if (board == null || board.length == 0)
            return "invalid board";

        int len = board.length;

        int rowSum = 0;     // 行和
        int colSum = 0;     // 列和
        int lDiaSum = 0;    // 左对角线和
        int rDiaSum = 0;    // 右对角线和
        boolean blank = false;// 是否有空白

        final int X_SUM = 'X' * len;
        final int O_SUM = 'O' * len;


        for (int i = 0; i < len; i++) {
            rowSum = 0;
            colSum = 0;
            for (int j = 0; j < len; j++) {

                char cl = board[i].charAt(j);
                char cr = board[j].charAt(i);

                blank = (blank) || (cl == ' '); // 记录board中是否有空白

                rowSum += cl;// 行和
                colSum += cr;// 列和
                lDiaSum += (i == j ? cl : 0);// 左对角线
                rDiaSum += (len == (i + j - 1) ? cl : 0);// 右对角线
            }

            if ((rowSum == X_SUM) || (colSum == X_SUM)) {
                return "X";
            }

            if ((rowSum == O_SUM) || (colSum == O_SUM)) {
                return "O";
            }
        }

        if ((lDiaSum == X_SUM) || (rDiaSum == X_SUM)) {
            return "X";
        }

        if ((lDiaSum == O_SUM) || (rDiaSum == O_SUM)) {
            return "O";
        }

        return blank ? "Pending" : "Draw";
    }

    @Test
    public void case_01() {
        String[] board = {"O X", " XO", "X O"};
        System.out.println(tictactoe(board));
    }

    @Test
    public void case_02() {
        String[] board = {"OOX", "XXO", "OX "};
        System.out.println(tictactoe(board));
    }

    @Test
    public void case_03() {
        String[] board = {"OOX", "XXO", "OXO"};
        System.out.println(tictactoe(board));
    }

    @Test
    public void case_04() {
        String[] board = {" OOO", "    ", "OXXX", "XX O"};
        System.out.println(tictactoe(board));
    }
}
