package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer, Integer> nums;
    List<Integer> lst;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new HashMap<>();
        lst = new ArrayList<>();

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (nums.containsKey(val)) {
            return false;
        }
        lst.add(val);
        nums.put(val, lst.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!nums.containsKey(val)) {
            return false;
        }
        // swap curr element with last element
        int index = nums.get(val);
        int last = lst.get(lst.size() - 1);
        nums.remove(val);
        if (last != val) {
            nums.remove(last);
            lst.remove(lst.size() - 1);
            // rehash with new value
            lst.set(index, last);
            nums.put(last, index);
        } else {
            lst.remove(lst.size() - 1);
        }
        
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int rand = random.nextInt(lst.size());
        return lst.get(rand);
    }
}
