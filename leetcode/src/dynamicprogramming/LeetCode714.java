package dynamicprogramming;

import java.util.Arrays;
import java.util.Map;

/**
 * 既然可以无限制的进行交易，那么设有俩变量
 * dp[i][0]:定义为购买时的最佳价格
 * dp[i][1]:定义当天非持有时的最佳价格
 * 购买最佳价格为前一天最佳价格，或者前一天售出的情况下，利用其本金继续购买，减去手续费得到的购买最佳价格
 * 卖出可以定义为前一天卖出的最佳价格，和当天卖出的价格，两种情况迭代进行讨论，互不干扰，由子问题推导父问题
 */
public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0] -fee; //买断
        dp[0][1] = 0; //隔岸观火
        for(int i = 1; i  < prices.length; i++){
           dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] -prices[i] - fee); // 之前买入的价格，和当前买入的价格，取较大值
           dp[i][1] = Math.max(dp[i - 1][1],prices[i]  + dp[i - 1][0]); // 之前买入的价格，和当前买入的价格，取较大值
        }
        return dp[prices.length - 1][1];
    }
}
