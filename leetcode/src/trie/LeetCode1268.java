package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 *
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 *
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * 示例 2：
 *
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 示例 3：
 *
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 示例 4：
 *
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 */

/**
 * 1。将 produce 里的产品统一构建数，节省空间存储
 */
public class LeetCode1268 {
    private class Tree {
        List<Tree> dict = new ArrayList<>(Collections.nCopies(26, null));
        boolean isEnd;
    }

    private Tree root;
    private List<String> res = new ArrayList<>();

    private void insert(String text) {
        var cur = root;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int index = ch - 'a';
            if (cur.dict.get(index) == null) {
                cur.dict.set(index, new Tree());
            }
            cur = cur.dict.get(index);
            if (i == text.length() - 1) {
                cur.isEnd = true;
            }
        }
    }

    private List<String> searchStartWith(String sub) {
        var cur = root;
        res.clear();
        for (int i = 0; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            int index = ch - 'a';
            if (cur.dict.get(index) == null) {
                return  new ArrayList<>();
            }
            cur = cur.dict.get(index);

        }
        if(cur.isEnd){
            res.addLast(sub);
        }
        dfs(cur, res, sub);
        return new ArrayList<>(res);
    }

    private void dfs(Tree cur, List<String> list, String curStr) {
        final int MAX_SIZE = 3;
        if (list.size() >= MAX_SIZE) {
            return;
        }

        var dict = cur.dict;
        for (int i = 0; i < dict.size(); i++) {
            if (dict.get(i) == null) {
                continue;
            }
            String newStr = curStr + (char) ('a' + i);
            if (dict.get(i).isEnd) {
                list.add(newStr);
            }
            dfs(dict.get(i), list, newStr);
            if (list.size() >= MAX_SIZE) {
                return;
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Tree();
        for (var str : products) {
            insert(str);
        }
        List<List<String>> list = new ArrayList<>(1001);
        String startWith = "";
        for (int i = 0; i < searchWord.length(); i++) {
            startWith += searchWord.charAt(i);
            List<String> subStrRes = searchStartWith(startWith);
            list.addLast(subStrRes);
        }
        return list;
    }
}
