package LeetCode;

import java.util.Arrays;

public class NumberScores {

    static int[] digitArr(int number) {
        String temp = Integer.toString(number);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }

    static int compute_number_score(int number) {
        int[] digits = digitArr(number);

        int sum = 0;
        sum += number % 7 == 0 ? 1 : 0;

        sum += (Arrays.stream(digits).filter(num -> num % 2 == 0).count()) * 2;

        sum += (Arrays.stream(digits).filter(num -> num == 9).count()) * 4;

        int streak = 1;
        for (int i = 1; i < digits.length; ++i) {
            if (digits[i] - digits[i - 1] == 1) {
                ++streak;
            } else {
                sum += streak * streak;
                streak = 1;
            }
        }
        //if (streak > 1) {
            sum += streak * streak;
        //}

        for (int i = 1; i < digits.length; ++i) {
            if (digits[i] == 1 && digits[i - 1] == 1) {
                sum += 5;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(compute_number_score(11111));
    }
}
