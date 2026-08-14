package heap;

import java.util.PriorityQueue;

/**
 * 找出第 k  大的元素
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(var num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        if(!pq.isEmpty()){
            return pq.peek();
        }
        return -1;
    }
}
