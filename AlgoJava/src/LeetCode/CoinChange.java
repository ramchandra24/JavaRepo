package LeetCode;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = 0; j < dp.length; ++j) {
                if (j >= coins[i] && dp[j - coins[i]] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return (dp[amount] < Integer.MAX_VALUE ? dp[amount] : -1);
    }

    public static void main(String[] args) {
        int coins = CoinChange.coinChange(new int[] { 2, 5 }, 7);
        System.out.println(coins);
    }
}
