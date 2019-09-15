package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumMeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        List<Integer> startTimes = Arrays.stream(intervals).map(a -> a[0]).sorted().collect(Collectors.toList());
        List<Integer> endTimes = Arrays.stream(intervals).map(a -> a[1]).sorted().collect(Collectors.toList());
        startTimes.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
        endTimes.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
        int maxcount = 0;
        int mcount = 0;
        for (int i = 0, j = 0; i < intervals.length && j < intervals.length;) {
            if (startTimes.get(i) < endTimes.get(j)) {
                ++mcount;
                if (mcount > maxcount) {
                    maxcount = mcount;
                }
                ++i;
            } else {
                --mcount;
                ++j;
            }
        }
        return (maxcount);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 8 }, { 6, 20 }, { 9, 16 }, { 13, 17 } };
        System.out.println(MinimumMeetingRooms.minMeetingRooms(intervals));
    }
}
