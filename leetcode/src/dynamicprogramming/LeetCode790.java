package dynamicprogramming;

public class LeetCode790 {
    /**
     * todo 未来实现一下矩阵快速幂求解
     */
    private static final int p = (int) (1e9 + 7);
    private final  static  int[] dp = new int[1001];
    static {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < dp.length; i++){
            dp[i] = (int)((dp[i - 1] * 2L + dp[i - 3]) % p);
        }
    }
    public int numTilings(int n) {
        return dp[n];
    }
}
