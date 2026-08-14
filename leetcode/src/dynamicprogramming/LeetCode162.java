package dynamicprogramming;

public class LeetCode162 {
    /**
     *
     * dp线性扫描，全局峰值也为局部峰值，那么找到全局峰值即可，由于左右不相等，那么当l与r相等的时候，那么这个数一定是峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int lMax = nums[0];
        dp1[0] = lMax;
        for(int i = 1 ; i < n ; i++){
            dp1[i] = Math.max(dp1[i],nums[i]);
        }
        for(int i = 1 ; i < n ; i++){
            dp1[i] = Math.max(dp1[i],nums[i]);
        }
        int rMax = nums[n - 1];
        dp2[n - 1] = rMax;
        for(int i = n - 2 ; i >= 0; i--){
            dp2[i] = Math.max(dp2[i],nums[i]);
        }
        for(int i = 0 ; i < n ; i++){
            if(dp1[i] == dp2[i]){
                return i;
            }
        }
        return -1;
    }
}

