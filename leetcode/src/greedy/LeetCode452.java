package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {
    /**
     *如果当前上界不足媲美下界，自然多需一位数据
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points){
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int up = points[0][1];
        int res = 0;
        for(int i = 1; i < points.length; i++){
            if(up < points[i][0]) {
                res++;
                up = points[i][1];
            }
        }
        return res;
    }
}
