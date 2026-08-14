package twopointers;

import java.util.*;

public class LeetCodeLcr007 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length && nums[i]  <= 0; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int total = nums[l] + nums[r] + nums[i];
                if(total == 0) {
                    res.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else{
                    if(total < 0) l++;
                    else r--;
                }
            }
        }
        return  new ArrayList<>(res);
    }
}
