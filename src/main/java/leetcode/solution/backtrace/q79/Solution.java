package leetcode.solution.backtrace.q79;
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */

/**
 * 79. 单词搜索
 *
 * @author noodle
 * @date 2019/8/20 10:12
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean exist = dfs(board, mark, i, j, word, 0);
                if (exist)
                    return exist;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] mark, int i, int j, String word, int cur) {
        if (cur == word.length() - 1)
            return board[i][j] == word.charAt(cur);

        if (board[i][j] == word.charAt(cur)) {
            mark[i][j] = true;

            int newX = i - 1;
            int newY = j;
            if (inArea(mark, newX, newY) && mark[newX][newY]) {
                if (dfs(board, mark, newX, newY, word, cur + 1))
                    return true;
            }


            newX = i + 1;
            newY = j;
            if (inArea(mark, newX, newY) && mark[newX][newY]) {
                if (dfs(board, mark, newX, newY, word, cur + 1))
                    return true;
            }


            newX = i;
            newY = j - 1;
            if (inArea(mark, newX, newY) && mark[newX][newY]) {
                if (dfs(board, mark, newX, newY, word, cur + 1))
                    return true;
            }


            newX = i;
            newY = j + 1;
            if (inArea(mark, newX, newY) && mark[newX][newY]) {
                if (dfs(board, mark, newX, newY, word, cur + 1))
                    return true;
            }
        }

        mark[i][j] = false;

        return false;
    }

    private boolean inArea(boolean[][] mark, int newX, int newY) {
        return newX >= 0 && newX < mark.length && newY >= 0 && newY < mark[0].length;
    }
}