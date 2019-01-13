import java.util.*;
public class cl49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<List<String>>();
        Map<String, List<String>> dict = new HashMap<String, List<String>>();
        for(int i=0; i<strs.length; i++){
            char temp[] = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = new String(temp);
            if(!dict.containsKey(str)){
                List<String> nlist = new ArrayList<>();
                nlist.add(strs[i]);
                dict.put(str, nlist);
            }
            else{
                List<String> nlist = dict.get(str);
                nlist.add(strs[i]);
                dict.put(str, nlist);
            }
        }
        return new ArrayList<List<String>>(dict.values());
    }
}
