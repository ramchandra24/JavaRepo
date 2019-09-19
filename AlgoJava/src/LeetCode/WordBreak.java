package LeetCode;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();
        for (String word : wordDict) {
            dictionary.add(word);
        }
        return wordBreakUtil(s, dictionary);
    }

    public static boolean wordBreakUtil(String s, Set<String> dictionary) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 1; i <= s.length(); ++i) {
            String curr = s.substring(0, i);
            System.out.println(curr);
            if (dictionary.contains(curr) && wordBreakUtil(s.substring(i, s.length()), dictionary)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(WordBreak.wordBreak("leetncode", dict));
    }
}
