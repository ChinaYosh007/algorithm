package binarysearch;

import java.util.Arrays;

public class LeetCode875 {
    /**
     *从最小到最大二分枚举收缩
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while( l < r){
            int mid =  l + (r - l ) / 2;
            if(canFinsh(piles,mid,h)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canFinsh(int[] piles, int mid, int h) {
        int cost = 0;
        for(int pile : piles){
            cost += (pile + mid - 1) / mid;
            if(cost > h) return false;
        }
        return true;
    }
}
