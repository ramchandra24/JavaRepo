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

    public static class Pair {
        String s;
        int level;

        Pair(String s, int level) {
            this.s = s;
            this.level = level;
        }

        String getKey() {
            return this.s;
        }

        int getValue() {
            return this.level;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair currPair = q.poll();
            String currWord = currPair.getKey();
            int currLevel = currPair.getValue();
            System.out.println(currWord);
            Iterator<String> it = wordSet.iterator();
            while (it.hasNext()) {
                String s = it.next();
                if (isAdjacent(s, currWord)) {
                    //System.out.println("adding " + s + " to the queue");
                    q.add(new Pair(s, currLevel + 1));
                    if (s.compareTo(endWord) == 0) {
                        return currLevel + 1;
                    }
                    it.remove();
                }
            }
            wordSet.remove(currWord);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                WordLadder.ladderLength("a", "c", Arrays.asList("a", "b", "c")));
    }
}
