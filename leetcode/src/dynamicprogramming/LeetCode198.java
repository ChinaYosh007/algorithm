package dynamicprogramming;

public class LeetCode198 {
    public int rob(int[] cost) {
        int n = cost.length;
        if(n == 1) return  cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = Math.max(cost[0],cost[1]);
        for(int i = 2; i < n ; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + cost[i]);
        }
        return Math.max(dp[n - 1],dp[n - 2]);
    }
}
