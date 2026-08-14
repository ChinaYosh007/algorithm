package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode216 {
    private List<List<Integer>> res = new LinkedList<>();
    private List<Integer> tmp = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        tmp.clear();
        dfs(0,0,k,0,n);
        return res;
    }

    private void dfs(int idx,int cnt, int k,int cur, int total) {
        if(cur > total) return;
        if(cnt == k){
            System.out.println(tmp);
            if(total == cur){
                res.add(new ArrayList<>(tmp));
            }
          return;
        }
        for(int i = idx + 1; i < 10; i++){
                tmp.addLast(i);
                dfs(i,cnt + 1,k,cur + i,total);
                tmp.removeLast();

        }
    }

}
