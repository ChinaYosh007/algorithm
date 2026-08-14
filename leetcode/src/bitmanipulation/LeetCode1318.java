package bitmanipulation;

public class LeetCode1318 {
    /**
     * 分类讨论:
     * 当前位数 a | b  与 c的关系
     * 当 c 为 1 时，说明 a | b 相同 --> 反转任意一个即可
     * 当 c 为 0 时，就需要将 a 和 b 为 1 还是 0 进行分类讨论
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int minFlips(int a, int b, int c) {
    int cnt = 0;
    int mod = 0;
    for(int i = 0 ;i < 31; i++ ) {
        int btnA = a >> i & 1;
        int btnB = b >> i & 1;
        int btnC = c >> i & 1;
        //进制
        int or = btnA | btnB;
        if(or != btnC){
            if (btnC == 1) {
                cnt++;
            } else {
                cnt += btnA + btnB;
            }
        }
    }
    return cnt;
    }
}
