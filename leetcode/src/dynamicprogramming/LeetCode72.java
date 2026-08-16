package dynamicprogramming;

import java.util.List;
import java.util.stream.Stream;

/**
 * 分为三种情况对比不相等的时候的取值，
 * 设dp为最小操作数，那么设置最小数值是从空开始，得到相关数据
 * 然后根据当前元素是否相等，获取相对的选择权，如果相等，则代表我们不需要进行抉择
 * 否则从l insert
 *      r delete
 *      u replace
 *      三种情况渠道最小值然后进行抉择
 *
 */
public class LeetCode72 {
    public int minDistance(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        // 第一列
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        // 第一行
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m ;j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 +  Stream.of(dp[i - 1][j],dp[i][j - 1],dp[i - 1][j - 1]).toList().stream().min(Integer::compare).get();
                }

            }
        }
        return dp[n][m];
    }
}
