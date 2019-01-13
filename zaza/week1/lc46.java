import java.util.*;

public class lc46 {
    List<List<Integer>> ans;
    int[] myNums;
    int[] visit;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<>();
        ans = new ArrayList<>();
        myNums = nums;
        if(nums.length == 1){
            List<Integer> subAns = new ArrayList<>();
            subAns.add(myNums[0]);
            ans.add(subAns);
            return ans;
        }
        visit = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            List<Integer> subAns = new ArrayList<>();
            subAns.add(myNums[i]);
            visit[i] = 1;
            dfs(subAns);
            visit[i] = 0;
        }
        return ans;
    }

    public void dfs(List subAns){
        for(int i = 0; i < visit.length; i++){
            if(visit[i] == 0){
                subAns.add(myNums[i]);
                visit[i] = 1;
                if(subAns.size() == visit.length){
                    List<Integer> temp = new ArrayList(subAns);
                    ans.add(temp);
                    subAns.remove(new Integer(myNums[i]));
                    visit[i] = 0;
                }
                else{
                    dfs(subAns);
                    subAns.remove(new Integer(myNums[i]));
                    visit[i] = 0;
                }
            }
        }
    }
}
