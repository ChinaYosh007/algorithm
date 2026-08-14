package monotonicstack;

import java.util.Stack;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int[] res = new int[temperatures.length];
        for(int i = 1; i < temperatures.length; i++){
            /**
             * 弹掉非必要的元素
             */
            while(temperatures[stk.peek()] < temperatures[i]){
                Integer pop = stk.pop();
                res[pop] = i - pop;
            }
            stk.push(i);
        }
        return  res;
    }
}
