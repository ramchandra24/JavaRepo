package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mp = new HashMap<>();
        List<String> result = new LinkedList<>();
        for (List<String> tkts : tickets) {
            mp.putIfAbsent(tkts.get(0), new PriorityQueue<String>());
            mp.get(tkts.get(0)).offer(tkts.get(1));
        }
        findItineraryUtil(mp, result, "JFK");
        return result;
    }
    
    private static void findItineraryUtil(Map<String, PriorityQueue<String>> mp, List<String> result, String start) {
        while(mp.containsKey(start) && !mp.get(start).isEmpty()) {
            findItineraryUtil(mp, result, mp.get(start).poll());
        }
        result.add(0, start);
    }

    public static void main(String[] args) {
        List<List<String>> itinerary = new ArrayList<List<String>>();
        itinerary.add(Arrays.asList("JFK", "SFO"));
        itinerary.add(Arrays.asList("JFK", "ATL"));
        itinerary.add(Arrays.asList("SFO", "ATL"));
        itinerary.add(Arrays.asList("ATL", "JFK"));
        itinerary.add(Arrays.asList("ATL", "SFO"));
        List<String> res = FindItinerary.findItinerary(itinerary);
        System.out.println(res);
    }
}
