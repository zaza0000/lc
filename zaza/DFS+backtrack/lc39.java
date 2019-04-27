package DFSandBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target <= 0)
            return res;
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> subList, int[] candidates, int remain, int startIndex) {
        for (int i = startIndex; i < candidates.length; i++) {
            if (remain < candidates[i]){
                break;
            }
            //if (i > startIndex && candidates[i] == candidates[i-1])  //for duplicated case
            //    continue;
            subList.add(candidates[i]);
            if (remain == candidates[i]) {
                res.add(new ArrayList<Integer>(subList));
            } else {
                backtrack(res, subList, candidates, remain-candidates[i], i);
            }
            subList.remove(subList.size()-1);
        }
    }
}
