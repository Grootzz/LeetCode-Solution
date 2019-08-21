package leetcode.solution.tree.q208;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * @author noodle
 * @date 2019/8/21 17:02
 */
public class Trie {
    /**
     * 记录前缀树的根
     */
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
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

    /**
     * Returns if the word is in the trie.
     */
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

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
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
 * 定义前缀树节点
 */
class TrieNode {
    /**
     * 每个trie节点的孩子节点都有26个，对应26个字母
     */
    TrieNode[] children;

    /**
     * 记录本节点是否为一个单词的末尾
     */
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

