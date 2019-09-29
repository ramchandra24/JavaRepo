package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestNRSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> index = new HashMap<>();
        int currLength = 0;
        int maxLength = 0;
        int prevIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (index.containsKey(s.charAt(i))) {
                prevIndex = index.get(s.charAt(i)) > prevIndex ? index.get(s.charAt(i)) : prevIndex;
                currLength = i - prevIndex;
            } else {
                currLength++;
            }
            index.put(s.charAt(i), i);
            if (currLength > maxLength) {
                maxLength = currLength;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "taabcdteb";
        System.out.println(LongestNRSubstring.lengthOfLongestSubstring(s));
    }

}
