package leetcode.solution.backtrace.q212;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 * @author noodle
 * @date 2019/8/21 18:42
 */
public class Solution {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }

            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;

            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null)
                    return false;
                node = node.children[c - 'a'];
            }

            return true;
        }
    }

    /**
     * solution
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<String> ans = new ArrayList<>();
        boolean[][] visit = new boolean[board.length][board[0].length];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String cur = "";
                cur += board[i][j];
                dfs(board, visit, set, trie, cur, i, j);
            }
        }

        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, boolean[][] visit, Set<String> set, Trie trie, String cur, int x, int y) {
        // 当前字符串在字典树中存在
        if (trie.search(cur)) {
            set.add(cur);
        }

        // 如果当前字符串不是前缀，直接返回，终止后续dfs
        if (!trie.startsWith(cur))
            return;

        visit[x][y] = true;

        // 向左
        int newX = x - 1;
        int newY = y;
        if (inArea(visit, newX, newY) && !visit[newX][newY]) {
            dfs(board, visit, set, trie, cur + board[newX][newY], newX, newY);
        }

        newX = x + 1;
        newY = y;
        if (inArea(visit, newX, newY) && !visit[newX][newY]) {
            dfs(board, visit, set, trie, cur + board[newX][newY], newX, newY);
        }

        newX = x;
        newY = y - 1;
        if (inArea(visit, newX, newY) && !visit[newX][newY]) {
            dfs(board, visit, set, trie, cur + board[newX][newY], newX, newY);
        }

        newX = x;
        newY = y + 1;
        if (inArea(visit, newX, newY) && !visit[newX][newY]) {
            dfs(board, visit, set, trie, cur + board[newX][newY], newX, newY);
        }

        visit[x][y] = false;
    }

    private boolean inArea(boolean[][] mark, int newX, int newY) {
        return newX >= 0 && newX < mark.length && newY >= 0 && newY < mark[0].length;
    }


    @Test
    public void doTest() {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        List<String> ans = findWords(board, words);
        System.out.println(ans);
    }

    @Test
    public void doTest01() {
        String[] words = {"ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb"};
        char[][] board = {
                {'a', 'b'},
                {'c', 'd'}};

        List<String> ans = findWords(board, words);
        System.out.println(ans);
    }
}

