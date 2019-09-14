package LeetCode;

import java.util.Arrays;
import java.util.Map;

public class KClosestPoints {

    public static int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        Arrays.stream(points).forEach(a -> {
            System.out.print(a[0] + ", ");
            System.out.println(a[1]);
        });
        return Arrays.copyOf(points, K);
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        Arrays.stream(KClosestPoints.kClosest(points, 2)).forEach(a -> {
            System.out.print(a[0] + ", ");
            System.out.println(a[1]);
        });
    }
}
