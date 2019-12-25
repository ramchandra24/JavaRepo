package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

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
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            for (int i = 0; i < (int)curr.getValue(); ++i) {
                sb.append(curr.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharsByFreq obj = new SortCharsByFreq();
        String res = obj.frequencySort("tree1212212");
        System.out.println(res);
    }
}
