import java.util.Arrays;

public class LeetCode2300 {
    /**
     * 倘若一个组合成功，那么其后续一定成功 --> 推导结论
     * 排序 - > 二分
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l, r;
            l = 0 ; r = m;
             // 以r 为基准收缩， l 和 其右边一定可以实现
            while(l < r){
                int mid = l + (r - l) / 2;
                if( (long) potions[mid] * spells[i] >= success){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            res[i] = m - l;
        }
        return res;
    }
}
