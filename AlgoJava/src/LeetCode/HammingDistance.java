package LeetCode;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int same = x ^ y;
        int count = 0;
        for (int i = 0; i < 31; ++i) {
            count += same & 1;
            same = same >> 1;
        }
        return (count);
    }
    
    public static void main(String[] args) {
        System.out.println(HammingDistance.hammingDistance(1, 4));
    }
}
