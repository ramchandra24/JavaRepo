package LeetCode;

public class JumpingJack {

    static boolean findSum(int n, int k) {
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum += i;
            if (sum == k) {
                return true;
            }
        }
        return false;
    }

    static int maxStep(int n, int k) {
        if (findSum(n, k)) {
            return (n * (n + 1) / 2 - 1);
        }
        return (n * (n + 1) / 2);
    }
    
    public static void main(String[] args) {
         System.out.println(maxStep(1,1));
    }
}
