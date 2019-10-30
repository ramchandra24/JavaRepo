package LeetCode;

import java.util.*;

public class LetterCombinationPhoneNum {
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) {
            return new ArrayList<String>();
        }
        String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> results = new ArrayList<String>();
        letterCombUtil(digits, new String(), 0, letters, results);
        return results;
    }

    private void letterCombUtil(String digits, String build, int start, String[] letters, List<String> results) {
        if (start >= digits.length()) {
            results.add(build);
            //System.out.println(results);
            return;
        }
        // for (int i = start; i < digits.length(); ++i) {
        String currLetters = letters[digits.charAt(start) - '0' - 2];
        for (int j = 0; j < currLetters.length(); ++j) {
            // letterCombUtil(digits, build, i+1, letters, results);
            letterCombUtil(digits, build + currLetters.charAt(j), start + 1, letters, results);
            // }
        }
    }

    public static void main(String[] args) {
        LetterCombinationPhoneNum obj = new LetterCombinationPhoneNum();
        List<String> res = obj.letterCombinations("23456");
        System.out.println(res);
    }
}
