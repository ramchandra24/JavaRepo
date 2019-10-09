package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static int squareSumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    public static boolean isHappy(int n) {
        Set<Integer> sqSet = new HashSet<>();
        while (n != 1) {
            n = squareSumDigits(n);
            if (sqSet.contains(n)) {
                return false;
            } 
            sqSet.add(n);
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
}
