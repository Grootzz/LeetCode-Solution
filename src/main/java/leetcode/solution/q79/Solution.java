package leetcode.solution.q79;

import org.junit.Test;

/**
 * @author noodle
 * @date 2019/7/24 22:29
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean exist = DFS(board, mark, i, j, word, 0);
                if (exist)
                    return true;
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, boolean[][] mark, int i, int j, String word, int cur) {
        if (cur == word.length() - 1)
            return board[i][j] == word.charAt(cur);

        if (board[i][j] == word.charAt(cur)) {
            mark[i][j] = true;

            // 上
            int newX = i - 1;
            int newY = j;
            if (inArea(mark, newX, newY) && !mark[newX][newY]) {
                if (DFS(board, mark, newX, newY, word, cur + 1))
                    return true;
            }

            // 下
            newX = i + 1;
            newY = j;
            if (inArea(mark, newX, newY) && !mark[newX][newY]) {
                if (DFS(board, mark, newX, newY, word, cur + 1))
                    return true;
            }

            // 左
            newX = i;
            newY = j - 1;
            if (inArea(mark, newX, newY) && !mark[newX][newY]) {
                if (DFS(board, mark, newX, newY, word, cur + 1))
                    return true;
            }

            // 右
            newX = i;
            newY = j + 1;
            if (inArea(mark, newX, newY) && !mark[newX][newY]) {
                if (DFS(board, mark, newX, newY, word, cur + 1))
                    return true;
            }
        }

        mark[i][j] = false;

        return false;
    }

    private boolean inArea(boolean[][] mark, int newX, int newY) {
        return newX >= 0 && newX < mark.length && newY >= 0 && newY < mark[0].length;
    }

    @Test
    public void case01() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "ABCCED";

        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    @Test
    public void case02() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "SEE";

        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    @Test
    public void case03() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "ABCB";

        boolean exist = exist(board, word);
        System.out.println(exist);
    }
}
