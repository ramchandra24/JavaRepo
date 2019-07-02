package LeetCode;

import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstUniqueChar {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (int i=0; i < s.length(); ++i) {
            if (m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), -1);
            }
            else {
                m.put(s.charAt(i), i);
            }
        }
//        m.keySet().stream()
//        .map(k -> m.get(k))
//        .forEach(System.out::println);

        int min = Integer.MAX_VALUE;
        for (Character ch : m.keySet()) {
            if (m.get(ch) > -1 && m.get(ch) < min) {
                min = m.get(ch);
            }
        }
        return (min == Integer.MAX_VALUE? -1 : min);
    }
    
    public static void main(String[] args) {
        String s = new String("loveleetcode");
        System.out.println(FirstUniqueChar.firstUniqChar(s));
    }
}
