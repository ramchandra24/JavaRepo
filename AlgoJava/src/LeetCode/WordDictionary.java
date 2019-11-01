package LeetCode;

import java.util.Set;
import java.util.HashSet;

public class WordDictionary {
    class Node {
        char ch;
        Node[] nodes;
        boolean endOfWord;

        public Node(char ch) {
            this.ch = ch;
            nodes = new Node[26];
            endOfWord = false;
        }

        public Node() {
            // TODO Auto-generated constructor stub
            nodes = new Node[26];
            endOfWord = false;
        }

    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public int getCharIndex(char ch) {
        return ch - 'a';
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = getCharIndex(word.charAt(i));
            if (curr.nodes[index] == null) {
                curr.nodes[index] = new Node(word.charAt(i));
            }
            curr = curr.nodes[index];
        }
        if (curr != root) {
            curr.endOfWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchUtil(word, root, 0);
    }

    private boolean searchUtil(String word, Node root, int index) {
        if (root == null) {
            return false;
        }
        if (index == word.length()) {
            if (root.endOfWord == true) {
                return true;
            }
            return false;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < root.nodes.length; ++i) {
                if (searchUtil(word, root.nodes[i], index + 1) == true) {
                    return true;
                }
            }
        } else {
            return searchUtil(word, root.nodes[getCharIndex(word.charAt(index))], index + 1);
        }
        return false;
    }

    private boolean isWordComplete(String word) {
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) == '.') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bat");
        wd.addWord("det");
        wd.addWord("cat");
        wd.addWord("dat");
        System.out.println(wd.search(".."));

    }
}
