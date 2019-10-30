package LeetCode;
import java.util.*;

public class MostCommonWord {
    
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        for (String word : banned) {
            wordSet.add(word.toLowerCase());
        }
        
        String[] words = paragraph.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            if (wordSet.contains(word)) {
                continue;
            }
            if(!countMap.containsKey(word)) {
                countMap.put(word, 1);
            } else {
                countMap.put(word, countMap.get(word) + 1);
            }
        }
        String common = "";
        int max = 0;
        for (String word : countMap.keySet()) {
            if (countMap.get(word) > max) {
                max = countMap.get(word);
                common = word;
            }
        }
        
        return common;
    }
}
