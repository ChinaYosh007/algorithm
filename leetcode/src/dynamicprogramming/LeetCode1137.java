package dynamicprogramming;

public class LeetCode1137 {
//    todo 未来实现一下矩阵快速幂求解
    public int tribonacci(int n) {
        int[] dp = new int[n + 3];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for(int i = 3; i < n + 3 ; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
