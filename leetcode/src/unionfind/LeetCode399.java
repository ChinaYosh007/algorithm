package unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. 除法求值
 */
public  class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        //`极端情况 --- > 权值无穷无尽
        UnionFind unionFind = new UnionFind(2 * n);
        // 存储对应的hash
        Map<String,Integer> map = new HashMap<>(2 * n);
        int id = 0;
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            // a / b = v
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            if(!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if(!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            // 解析 对应的式子
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);
            if(!map.containsKey(var1) || !map.containsKey(var2)) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(map.get(var1), map.get(var2));
            }
        }
        return res;
    }

    /**
     * 并查集
     *
     */
    private class UnionFind{
        private int[] parent;
        private double[] weight;
        public UnionFind(int n){
            parent = new int[n];
            weight = new double[n];
            for (int i  = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0;
            }
        }

        /**
         *  p / q = v
         *  w[p] = p / rootP
         *  --> rootP = p / w[p]
         *  w[q] = q / rootQ
         *  --> rootQ = q / w[q]
         *  todo  parent[rootP] = rootQ
         *  w[rootP] = rootP / rootQ;
         *  w[rootP] =  (p / w[p] )  *  ( w[q]  / q)
         *  w[rootP] = p * w[q] / (w[p] * q)
         *  w[rootP] = p * w[q] / w[p] / q
         *  w[rootP] = p / q * w[q] / w[p]
         *  w[rootP] = v * w[q] / w[p]
         * @param p
         * @param q
         * @param value
         */
        public void union(int p, int q, double value) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootQ != rootP){
                parent[rootP] = rootQ;

                weight[rootP] = value * weight[q] / weight[p];
            }
        }

        /**
         *  a / b = x
         *  b / c = y
         *  a / c = x * y
         *  a / c = (a / b ) * (b / c)
         *  w[a] = old.w[a] * w[b]
         * @param x
         * @return parent[x]
         */
        public  int find(int x) {
            if(x != parent[x]) {
               int origin = parent[x];
               parent[x] = find(parent[x]);
               weight[x] *= weight[origin];
            }
            return parent[x];
        }
        public double isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if(rootQ == rootP) {
                return weight[p] / weight[q];
            }
            return -1.0d;
        }
    }
}
