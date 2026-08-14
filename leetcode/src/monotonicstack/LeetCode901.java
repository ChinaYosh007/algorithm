package monotonicstack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode901 {
    private Stack<Integer> stk = new Stack<>();
    private List<List<Integer>> list = new LinkedList<>();


    public int next(int price) {
        if(stk.isEmpty()|| list.get(stk.peek()).getLast() > price){
            list.add(List.of(1,price));
            stk.push(list.size() - 1);
            return 1;
        }
        int day = 1;
        while(!stk.isEmpty() && list.get(stk.peek()).getLast() <= price){
            Integer pop = stk.pop();
            List<Integer> integers = list.get(pop);
            day += integers.getFirst();
        }
        list.add(List.of(day,price));
        stk.push(list.size() - 1);
        return day;
    }

}
