package LeetCode;

public class Poker {
    static int solution(int n, int k) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 0 && k > 0) {
                n /= 2;
                k--;
            } else {
                n--;
            }
            count++;
        }
        return count - 1;
    }

    public static void main(String[] args) {
        System.out.println(Poker.solution(8, 0));
        System.out.println(Poker.solution(18, 2));
        System.out.println(Poker.solution(10, 10));
        //System.out.println(Poker.solution(2, 10));
    }
}
