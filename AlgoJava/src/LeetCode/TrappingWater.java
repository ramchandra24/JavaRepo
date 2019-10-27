package LeetCode;

import java.util.List;

public class TrappingWater {
    public static int trap(int[] height) {
        if (height.length < 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int water = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                } else {
                    water += Math.min(maxLeft, maxRight) - height[left];
                }
                ++left;
            } else {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                } else {
                    water += Math.min(maxLeft, maxRight) - height[right];
                }
                --right;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(TrappingWater.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}
