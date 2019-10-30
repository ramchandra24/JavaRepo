package LeetCode;

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int partition = 0;
        partitionUtil(s, partition, result, new LinkedList<>());
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s.length() < 1) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    private void partitionUtil(String sb, int start, List<List<String>> result, Deque<String> level) {
        // System.out.println(sb);
        if (start >= sb.length()) {
            result.add(new ArrayList<>(level));
            // level.clear();
            return;
        }

        for (int i = start; i < sb.length(); ++i) {
            if (isPalindrome(sb.substring(start, i + 1))) {
                level.addLast(sb.substring(start, i + 1));
                partitionUtil(sb, i + 1, result, level);
                level.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        List<List<String>> res = obj.partition("aabaa");

        for (List<String> p : res) {
            System.out.println(p);
        }
    }
}
