package LeetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AlienDictionary {
    public static void DFSUtil(char ch, Map<Character, Boolean> visited, 
            Map<Character, List<Character>> g, Stack<Character> res) {
        visited.put(ch, true);
        System.out.print(ch + " ");
        //System.out.println(res);

        Iterator<Character> i = g.get(ch).listIterator();
        while (i.hasNext()) {
            char c = i.next();
            if (!visited.get(c)) {
                DFSUtil(c, visited, g, res);
            }
        }
        res.push(ch);
        //System.out.println(res);
    }

    public static Stack<Character> DFS(char ch, Map<Character, List<Character>> g) {
        Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
        for(Map.Entry<Character, List<Character>> gen : g.entrySet()) {
            visited.put(gen.getKey(), false);
        }
        Stack<Character> res = new Stack();
        //String result = new String();
        for (Map.Entry<Character, Boolean> entry : visited.entrySet()) {
            if (entry.getValue() == false) {
                ch = entry.getKey();
                visited.put(ch, true);
                DFSUtil(ch, visited, g, res);
            }
        }
        return res;
    }

    public static char[] firstDiff(String a, String b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); ++i) {
            if (a.charAt(i) != b.charAt(i)) {
                char[] ret = {a.charAt(i), b.charAt(i)};
                return ret;
            }
        }
        return null;
    }


    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); ++i) {
                if (!graph.containsKey(s.charAt(i))) {
                    graph.put(s.charAt(i), new LinkedList<Character>());
                }
            }
        }
        for (int i = 0; i < words.length - 1; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                char[] ch;
                if ((ch = firstDiff(words[i], words[j])) != null) {
                    if (graph.get(ch[1]).contains(ch[0])) {
                        return "";
                    }
                    if (!graph.get(ch[0]).contains(ch[1]) ) {
                        graph.get(ch[0]).add(ch[1]);
                    }
                }
            }
        }
        for (Map.Entry<Character, List<Character>> entry : graph.entrySet()) {
            System.out.println("Key = " + entry.getKey() + 
                    ", Value = " + entry.getValue());
        }
        Stack<Character> res = DFS(words[0].charAt(0), graph);
        String result = new String();
        while (!res.isEmpty() ) {
            result += res.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        String[] words = 
            {"wrt","wrf","er","ett","rftt"};
        String res = AlienDictionary.alienOrder(words);
        System.out.println(res);
    }
}
