package DFSandBacktrack;

import java.util.*;

public class lc301 {
    class Solution {
        List<String> res;
        Set<String> validSet;
        public List<String> removeInvalidParentheses(String s) {
            res = new ArrayList<>();
            if (s == null || s.length() == 0){
                res.add("");
                return res;
            } else if (s.length() == 1) {
                if(isPar(s.charAt(0)))
                    res.add("");
                else
                    res.add(s);
                return res;
            }

            if (checkValid(s)) {
                res.add(s);
                return res;
            }
            validSet = new HashSet<>();
            Set<String> resSet = new HashSet<>();
            resSet.add(s);
            helper(resSet);
            return res;
        }

        private void helper(Set<String> resSet) {
            if (resSet.contains("")){
                new ArrayList<>(resSet);
                return;
            }
            boolean find = false;
            Iterator<String> it = resSet.iterator();
            Set<String> nextSet = new HashSet<>();
            while (it.hasNext()) {
                String temp = it.next();
                int counter = 0;
                for (int i = 0; i < temp.length(); i++){
                    char ch = temp.charAt(i);
                    if(ch == '(')
                        counter++;
                    else if(ch == ')')
                        counter--;
                }
                int tempSize = temp.length();
                for (int i = 0; i < tempSize; i++) {
                    char tempChar = temp.charAt(i);
                    if(counter > 0 && tempChar == '(' || counter < 0 && tempChar == ')' ||
                            counter == 0 && isPar(tempChar)) {
                        String newStr = temp.substring(0, i)+temp.substring(i+1, tempSize);
                        //System.out.println(newStr);
                        if(checkValid(newStr)){
                            find = true;
                            validSet.add(newStr);
                        }
                        if (find == false) {
                            nextSet.add(newStr);
                        }
                    }
                }
            }
            if (find == true) {
                res = new ArrayList<>(validSet);
                return;
            } else {
                helper(nextSet);
                return;
            }
        }

        private boolean isPar(char c) {
            if(c == '(' || c == ')')
                return true;
            return false;
        }

        private boolean checkValid(String str) {
            int counter = 0;
            for (int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '(')
                    counter++;
                else if(ch == ')')
                    counter--;
                if(counter < 0)
                    return false;
            }
            if(counter == 0)
                return true;
            return false;
        }
    }
}

//public class Solution {
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> ans = new ArrayList<>();
//        remove(s, ans, 0, 0, new char[]{'(', ')'});
//        return ans;
//    }
//
//    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
//        for (int stack = 0, i = last_i; i < s.length(); ++i) {
//            if (s.charAt(i) == par[0]) stack++;
//            if (s.charAt(i) == par[1]) stack--;
//            if (stack >= 0) continue;
//            for (int j = last_j; j <= i; ++j)
//                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
//                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
//            return;
//        }
//        String reversed = new StringBuilder(s).reverse().toString();
//        if (par[0] == '(') // finished left to right
//            remove(reversed, ans, 0, 0, new char[]{')', '('});
//        else // finished right to left
//            ans.add(reversed);
//    }
//}


//class Solution {
//    public List<String> removeInvalidParentheses(String s) {
//        int lc = 0, rc = 0;
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) == ')'){
//                if(lc==0) rc++;
//                else lc--;
//            } else if(s.charAt(i) == '('){
//                lc++;
//            }
//        }
//        Set<String> res = new HashSet<String>();
//        recurse(s, 0, 0, 0, lc, rc, new StringBuilder(), res);
//        return new ArrayList<String>(res);
//    }
//    void recurse(String s, int index, int left, int right, int lc, int rc, StringBuilder sb, Set<String> set){
//        if(index == s.length() && lc == 0 && rc == 0) {
//            set.add(sb.toString());
//            return;
//        }
//        if(index == s.length()) return;
//        char c = s.charAt(index);
//        if((c == '(' && lc > 0) || (c == ')' && rc > 0)){
//            recurse(s, index+1, left, right,
//                    lc - (c == '(' ? 1 : 0),
//                    rc - (c == ')' ? 1 : 0), sb, set);
//        }
//        sb.append(c);
//        if(c != '(' && c != ')'){
//            recurse(s, index+1, left, right, lc, rc, sb, set);
//        } else if(c == '('){
//            recurse(s, index+1, left+1, right, lc, rc, sb, set);
//        } else if(left>right){
//            recurse(s, index+1, left, right+1, lc, rc, sb, set);
//        }
//        sb.deleteCharAt(sb.length()-1);
//    }
//}
