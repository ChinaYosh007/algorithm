package trie;

import java.util.*;

public class LeetCode208 {
    private class Tree{
        List<Tree> dict = new ArrayList<>(Collections.nCopies(26,null));
        boolean isEnd = false;
    }
    private Tree root = new Tree();

    public void insert(String word) {
        var cur = root;
        for(int i = 0 ; i < word.length(); i++){
           char c = word.charAt(i);
           int index = c - 'a';
           var dict = cur.dict;
            if (cur.dict.get(index) == null) {
                cur.dict.set(index,new Tree());
            }
            cur = dict.get(index);
            if(i == word.length() - 1){
                cur.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        var cur = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            var dict = cur.dict;
            if (cur.dict.get(index) == null){
              return false;
            }
            cur = dict.get(index);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        var cur = root;
        for(int i = 0 ; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            var dict = cur.dict;
            if (cur.dict.get(index) == null){
                return false;
            }
            cur = dict.get(index);
        }
        return true;
    }

}
