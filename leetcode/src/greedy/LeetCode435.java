package greedy;

import java.util.Arrays;

public class LeetCode435 {
    /**
     * 贪心策略，按照左区间进行排序，然后当cur_max的r比 cur 小，说明后面可能更大....
     *相反的，如果超过，删掉最大的那个区间度即可
     * @param a
     * @param b
     * @return
     */
    private int compare(int[] a, int[] b){
        if(a[0] != b[0]){
            return Integer.compare(a[0],b[0]);
        }
        return Integer.compare(a[1],b[1]);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,this::compare);
        int up = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            if(up <= intervals[i][0]){
                up = intervals[i][1];
            }else{
                up = Math.min(up,intervals[i][1]);
                res++;
            }
        }
        return res;
    }
}
