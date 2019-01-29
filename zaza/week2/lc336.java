import java.util.*;

public class lc336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if(words.length == 0)
            return ans;
        Map<String, Integer> hash = new HashMap<>();
        for(int i=0; i<words.length; i++){
            hash.put(new StringBuffer(words[i]).reverse().toString(), i);
        }
        if(hash.containsKey(""))
            for(int i=0; i<words.length; i++){
                if(isPalindrome(words[i])==true && !words[i].equals("")){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(hash.get(""));
                    pair.add(hash.get(words[i]));
                    ans.add(pair);
                }
            }
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                String left = words[i].substring(0,j);
                String right = words[i].substring(j,words[i].length());
                if(hash.containsKey(left) && isPalindrome(right)==true && hash.get(left)!=i){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(hash.get(left));
                    ans.add(pair);
                }
                if(hash.containsKey(right) && isPalindrome(left)==true && hash.get(right)!=i){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(hash.get(right));
                    pair.add(i);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s){
        char[] ss = s.toCharArray();
        int i = 0;
        int j = ss.length -1;
        while(i<j){
            if(ss[i] != ss[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}
