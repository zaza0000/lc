import java.util.*;

public class lc609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        if(paths.length == 0)
            return ans;
        Map<String, List<String>> hash = new HashMap<>();
        for(String s:paths){
            String[] path = s.split(" ");
            for(int i = 1; i < path.length; i++){
                String[] name = path[i].split("\\(");
                List<String> list = hash.getOrDefault(name[1], new ArrayList<String>());
                list.add(path[0]+"/"+name[0]);
                hash.put(name[1], list);
            }
        }
        for(String key: hash.keySet()){
            if(hash.get(key).size() > 1)
                ans.add(hash.get(key));
        }

        return ans;
    }
}
