package dynamicprogramming;

/**
 * LCS: 如果当前元素相同，那就按照上一个的结果 + 1,否则抉择出子串最优解，看选择 A还是B
 */
public class LeetCode1143 {
    private  int isEqual(char a,char b){
        if(a == b) return 1;
        return  0;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        dp[0][0] = isEqual(text1.charAt(0), text2.charAt(0));
        // 第一列
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(
                    dp[i - 1][0],
                    isEqual(text1.charAt(i), text2.charAt(0))
            );
        }
        // 第一行
        for (int j = 1; j < m; j++) {
            dp[0][j] = Math.max(
                    dp[0][j - 1],
                    isEqual(text1.charAt(0), text2.charAt(j))
            );
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m ;j++){
                int choose = isEqual(text1.charAt(i),text2.charAt(j));
                if(choose == 1){
                    dp[i][j] = dp[i - 1][j - 1] + choose;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }

            }
        }
        return dp[n - 1][m - 1];

    }
}
