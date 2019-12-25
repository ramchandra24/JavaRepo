package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CharCounter {
    char ch;
    int count;

    CharCounter(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class SortCharsByFreq {

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (!freqMap.containsKey(ch)) {
                freqMap.put(ch, 0);
            }
            Integer current = freqMap.get(ch);
            freqMap.put(ch, current + 1);
        }
        List<CharCounter> count = new ArrayList<>();
        for (Character ch : freqMap.keySet()) {
            count.add(new CharCounter(ch, freqMap.get(ch)));
        }
        count.sort((a, b) -> b.count - a.count);
        String result = "";
        for (int i = 0; i < count.size(); ++i) {
            int charCount = count.get(i).count;
            while (charCount > 0) {
                result += count.get(i).ch;
                charCount--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortCharsByFreq obj = new SortCharsByFreq();
        String res = obj.frequencySort("tree1212212");
        System.out.println(res);
    }
}
