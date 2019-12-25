package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
        if (s.length() < 1) {
            return s;
        }
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            Integer current = freqMap.getOrDefault(ch, 0);
            freqMap.put(ch, current + 1);
        }

        PriorityQueue<CharCounter> pq = new PriorityQueue<>(freqMap.size(), (a, b) -> b.count - a.count);

        for (Character ch : freqMap.keySet()) {
            pq.add(new CharCounter(ch, freqMap.get(ch)));
        }
        String result = "";

        while (!pq.isEmpty()) {
            CharCounter curr = pq.poll();
            while (curr.count > 0) {
                result += curr.ch;
                curr.count--;
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
