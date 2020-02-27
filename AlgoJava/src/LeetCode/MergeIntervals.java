package LeetCode;

import java.util.*;

public class MergeIntervals {
    class Interval {
        int x;
        int y;

        Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1)
            return null;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.x - b.x));
        for (int i = 0; i < intervals.length; ++i) {
            pq.offer(new Interval(intervals[i][0], intervals[i][1]));
        }
        int[][] result = new int[intervals.length][2];
        Interval intVal = pq.poll();
        result[0][0] = intVal.x;
        result[0][1] = intVal.y;
        int index = 0;
        while (!pq.isEmpty()) {
            intVal = pq.poll();
            if (result[index][1] >= intVal.x) {
                result[index][1] = Math.max(result[index][1], intVal.y);
            } else {
                ++index;
                result[index][0] = intVal.x;
                result[index][1] = intVal.y;
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}