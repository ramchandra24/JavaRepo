package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    private static boolean isAdjacent(String a, String b) {
        int differ = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                ++differ;
            }
        }
        return differ == 1 ? true : false;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int len = 1;
        q.add(beginWord);

        while (!q.isEmpty()) {
            String currWord = q.poll();
            System.out.println(currWord);
            Iterator<String> it = wordSet.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (isAdjacent(s, currWord)) {
                    q.add(s);
                    if (s.compareTo(endWord) == 0) {
                        return len;
                    }
                    ++len;
                }
            }
            wordSet.remove(currWord);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(WordLadder.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
