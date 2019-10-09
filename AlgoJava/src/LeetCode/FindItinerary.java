package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FindItinerary {

    static class Graph {
        int n;
        List<List<Integer>> adj;

        Graph(int v) {
            n = v;
            adj = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                adj.add(new LinkedList<>());
            }
        }

        void printAdjMat() {
            System.out.println(adj.size());
            for (List<Integer> row : adj) {
                for (int v : row) {
                    System.out.println(v + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        void addEdge(int u, int v) {
//            printAdjMat();
            adj.get(u).add(v);
        }

        void dfs(int v, boolean[] visited, Stack<Integer> s) {
            visited[v] = true;
            Iterator<Integer> it = adj.get(v).iterator();
            while (it.hasNext()) {
                int u = it.next();
                if (!visited[u]) {
                    dfs(u, visited, s);
                }
            }
            s.push(v);
        }

        List<Integer> topologicalSort(int start) {
            Stack<Integer> s = new Stack<>();
            boolean[] visited = new boolean[n];

            System.out.println("size: " + n);
            dfs(start, visited, s);
            for (int i = 0; i < n; ++i) {
                if (!visited[i]) {
                    dfs(i, visited, s);
                }
            }

            List<Integer> res = new ArrayList<>();
            while (!s.isEmpty()) {
                res.add(s.pop());
            }
            return res;
        }

    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<Integer, String> indexToCity = new HashMap<>();
        Map<String, Integer> cityToIndex = new HashMap<>();
        Set<String> addedCities = new HashSet<>();
        int jfkIndex = 0;
        int i = 0;
        int j = 0;
        while (j < tickets.size()) {
            String firstCity = tickets.get(j).get(0);
            String secondCity = tickets.get(j).get(1);
            if (!addedCities.contains(firstCity)) {
                if (0 == firstCity.compareTo("JFK")) {
                    jfkIndex = i;
                }
                indexToCity.put(i, firstCity);
                cityToIndex.put(firstCity, i);
                ++i;
            }
            if (!addedCities.contains(secondCity)) {
                if (0 == secondCity.compareTo("JFK")) {
                    jfkIndex = i;
                }
                indexToCity.put(i, secondCity);
                cityToIndex.put(secondCity, i);
                ++i;
            }
            addedCities.add(firstCity);
            addedCities.add(secondCity);
            j++;
        }
        // System.out.println(addedCities);
        System.out.println(cityToIndex);
        Graph g = new Graph(addedCities.size());
        for (int k = 0; k < tickets.size(); ++k) {
            String firstCity = tickets.get(k).get(0);
            String secondCity = tickets.get(k).get(1);
            System.out.println(firstCity + " " + secondCity);
            g.addEdge(cityToIndex.get(firstCity), cityToIndex.get(secondCity));
        }
        List<Integer> res = g.topologicalSort(jfkIndex);
        List<String> finalItinerary = new ArrayList<String>();
        for (int k = 0; k < res.size(); ++k) {
            finalItinerary.add(indexToCity.get(res.get(k)));
        }
        System.out.println(finalItinerary);

        return null;
    }

    public static void main(String[] args) {
        List<List<String>> itinerary = new ArrayList<List<String>>();
        itinerary.add(Arrays.asList("JFK", "SFO"));
        itinerary.add(Arrays.asList("JFK", "ATL"));
        itinerary.add(Arrays.asList("SFO", "ATL"));
        itinerary.add(Arrays.asList("ATL", "JFK"));
        itinerary.add(Arrays.asList("ATL", "SFO"));
        FindItinerary.findItinerary(itinerary);
    }
}
