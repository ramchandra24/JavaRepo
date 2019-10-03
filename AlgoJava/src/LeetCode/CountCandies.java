package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountCandies {

    static class Node {
        List<Set<Integer>> friends = new ArrayList<Set<Integer>>();
        int maxSet = 0;
        int maxProd = 0;
        int candy;

        Node(int candy, int friend_from, int friend_to) {
            this.candy = candy;
            friends.add(new HashSet<>(Arrays.asList(friend_from, friend_to)));
            maxSet = 1;
            maxProd = friend_from * friend_to;
        }

        int[] get2Max(Set<Integer> set) {
            int[] max = new int[2];
            max[0] = getMax(set);
            set.remove(max[0]);
            max[1] = getMax(set);
            set.add(max[0]);
            return max;
        }

        int getMax(Set<Integer> set) {
            int max = Integer.MIN_VALUE;
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                int a;
                if ((a = it.next()) > max) {
                    max = a;
                }
            }
            return max;
        }

        void add(int friend_from, int friend_to) {
            boolean added = false;
            int len = friends.size(); 
            for (int i = 0, first = -1; i < len; ++i) {
                if (friends.get(i).contains(friend_from) || friends.get(i).contains(friend_to)) {
                    friends.get(i).add(friend_from);
                    friends.get(i).add(friend_to);
                    if (first == -1) {
                        first = i;
                        if (friends.get(i).size() > maxSet) {
                            maxSet = friends.get(i).size();
                            int[] max = get2Max(friends.get(i));
                            maxProd = max[0] * max[1];
                        } else if (friends.get(i).size() == maxSet) {
                            int[] max = get2Max(friends.get(i));
                            maxProd = max[0] * max[1] > maxProd ? max[0] * max[1] : maxProd;
                        }
                    } else {
                        friends.get(i).addAll(friends.get(first));
                        friends.remove(first);
                        first = i - 1;
                        --i;
                        --len;
                        if (friends.get(i).size() > maxSet) {
                            maxSet = friends.get(i).size();
                            int[] max = get2Max(friends.get(i));
                            maxProd = max[0] * max[1];
                        } else if (friends.get(i).size() == maxSet) {
                            int[] max = get2Max(friends.get(i));
                            maxProd = max[0] * max[1] > maxProd ? max[0] * max[1] : maxProd;
                        }
                    }
                    added = true;
                }
            }
            if (!added) {
                friends.add(new HashSet<>(Arrays.asList(friend_from, friend_to)));
                if (maxSet == 1) {
                    maxProd = friend_from * friend_to > maxProd ? friend_from * friend_to : maxProd;
                }
            }
        }
    }

    public static int countCandies(int friends_nodes, List<Integer> friends_from, List<Integer> friends_to,
            List<Integer> friends_weight) {
        Map<Integer, Node> seg = new HashMap<>();

        for (int i = 0; i < friends_weight.size(); ++i) {
            int candy = friends_weight.get(i);
            Node friendList;
            if (seg.containsKey(candy)) {
                friendList = seg.get(candy);
                friendList.add(friends_from.get(i), friends_to.get(i));
            } else {
                seg.put(candy, new Node(candy, friends_from.get(i), friends_to.get(i)));
            }
        }
        int maxProd = 0;
        int maxCount = 0;
        for (Integer candy : seg.keySet()) {
            Node list = seg.get(candy);
            if (list.maxSet > maxCount) {
                maxCount = list.maxSet;
                maxProd = list.maxProd;
            } else if (list.maxSet == maxCount) {
                maxProd = list.maxProd > maxProd ? list.maxProd : maxProd;
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        List<Integer> from = new ArrayList<Integer>(Arrays.asList(5,1,1,2,2,2));
        List<Integer> to = new ArrayList<Integer>(Arrays.asList(5,2,2,3,3,4));
        List<Integer> candy = new ArrayList<Integer>(Arrays.asList(5,1,2,1,3,3));
        
        System.out.println(CountCandies.countCandies(4, from, to, candy));
    }
}
