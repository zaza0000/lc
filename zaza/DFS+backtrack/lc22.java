package DFSandBacktrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc22 {
    // brute force
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    // backtrack
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0)
            return res;
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String subStr, int leftNum, int rightNum, int n) {
        if (leftNum == n && rightNum == n){
            res.add(subStr);
            return;
        }
        if(leftNum < n)
            backtrack(res, subStr+"(", leftNum+1, rightNum, n);
        if(rightNum < leftNum)
            backtrack(res, subStr+")", leftNum, rightNum+1, n);
    }

    // Catalan number with memorization
    // https://baike.baidu.com/item/%E5%8D%A1%E7%89%B9%E5%85%B0%E6%95%B0
    Map<Integer, List<String>> hash;
    public List<String> generateParenthesis3(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0)
            return res;
        hash = new HashMap<>();
        List<String> p0 = new ArrayList<>();
        p0.add("");
        hash.put(0, p0);
        res = helper(n);
        return res;
    }

    private List<String> helper(int n) {
        if (n == 0)
            return hash.get(0);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<String> left;
            List<String> right;
            if(!hash.containsKey(i)){
                hash.put(i, helper(i));
            }
            left = hash.get(i);
            if(!hash.containsKey(n-i-1)){
                hash.put(n-i-1, helper(n-i-1));
            }
            right = hash.get(n-i-1);
            for (String l : left) {
                for(String r : right) {
                    res.add("("+l+")"+r);
                }
            }
        }
        return res;
    }
}

//    stupid way
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        if (n <= 0)
//            return res;
//        dfs(res, "()", 1, n);
//        Set<String> strSet = new HashSet<>(res);
//        res = new ArrayList<>(strSet);
//        return res;
//    }
//
//    private void dfs(List<String> res, String subStr, int curSize, int maxSize) {
//        if (curSize == maxSize) {
//            res.add(subStr);
//            return;
//        }
//        int strLength = subStr.length();
//        for (int i = 0; i < strLength; i++) {
//            String newStr = subStr.substring(0, i)+"()"+subStr.substring(i, strLength);
//            dfs(res, newStr, curSize+1, maxSize);
//        }
//    }
