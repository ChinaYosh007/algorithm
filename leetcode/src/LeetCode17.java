import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode17 {
    private  static final String[][] map = {
            {""},
            {""},
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r","s"},
            {"t","u","v"},
            {"w","x","y","z"}
    };
    private List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        res.clear();
        int n = digits.length();
        dfs(digits,"",0,n);
        return  res;
    }

    private void dfs(String digits,String curStr, int cur, int n) {
        if(cur == n){
            res.add(curStr);
            return;
        }
        int dig = Integer.valueOf(digits.charAt(cur)) - 48;
        String[] chars = map[dig];
        for(String c : chars){
            dfs(digits,curStr + c,cur + 1,n);
        }
    }
}
