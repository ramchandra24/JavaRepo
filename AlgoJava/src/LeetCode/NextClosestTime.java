package LeetCode;

import java.util.List;

public class NextClosestTime {
    public static String nextClosestTime(String time) {
        String nextTime;

        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        int[] digits = { hour / 10, hour % 10, min / 10, min % 10 };

        int fix;
        // try to lower minute digit
        if ((fix = getNextLargest(digits, digits[3])) != Integer.MAX_VALUE) {
            digits[3] = fix;
            return makeTimeFrom(digits);
        }
        if ((fix = getNextLargest(digits, digits[2])) != Integer.MAX_VALUE) {
            if (fix*10 + digits[3] < 60) {
                digits[3] = findMinDigit(digits);
                digits[2] = fix;
                return makeTimeFrom(digits);
            }
        }
        if ((fix = getNextLargest(digits, digits[1])) != Integer.MAX_VALUE) {
            if (digits[0] * 10 + fix < 24) {
                digits[3] = findMinDigit(digits);
                digits[2] = findMinDigit(digits);
                digits[1] = fix;
                return makeTimeFrom(digits);
            }
        }
        if ((fix = getNextLargest(digits, digits[0])) != Integer.MAX_VALUE) {
            if (fix * 10 + digits[1] < 24) {
                digits[3] = findMinDigit(digits);
                digits[2] = findMinDigit(digits);
                digits[1] = findMinDigit(digits);
                digits[0] = fix;
                return makeTimeFrom(digits);
            }
        }
        int minDigit = findMinDigit(digits);
        return makeTimeFrom(new int[] { minDigit, minDigit, minDigit, minDigit });
    }

    private static int findMinDigit(int[] data) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; ++i) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    private static String makeTimeFrom(int[] data) {
        return (Integer.toString(data[0]) + Integer.toString(data[1]) + ":" + Integer.toString(data[2])
                + Integer.toString(data[3]));
    }

    private static int getNextLargest(int[] data, int num) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; ++i) {
            if (data[i] > num && data[i] < max) {
                max = data[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(NextClosestTime.nextClosestTime("20:56"));
    }
}
