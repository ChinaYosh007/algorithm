package dynamicprogramming;

public class LeetCode790 {
    //todo need
    private final int p = (int) (1e9 + 7);
    public int numTilings(int n) {
        if(n < 2) return n;
        int[] dp = new int[2 * n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 2 * n ; i++){
            dp[i] = ((dp[i - 1] * 2 ) % p + dp[i - 2]) % p;
        }
        return dp[2 * 2 - 1];
    }
}
