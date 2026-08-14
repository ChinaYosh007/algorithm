package bitmanipulation;

public class LeetCode338 {
    public int[] countBits(int n) {
        int[] popCount = new int[n + 1];
        popCount[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            popCount[i] = popCount[i >> 1] + (i & 1);
        }
        return  popCount;
    }

}
