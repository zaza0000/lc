package DFSandBacktrack;

import java.util.ArrayList;
import java.util.List;

public class lc216 {
    private int[] nums;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > 9 || n > 45)
            return res;
        nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i+1;
        }
        backtrack(res, new ArrayList<>(), n, 0, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> subList, int remain, int index, int k) {
        if (remain < 0 || subList.size() > k) {
            return;
        }
        if (remain == 0 && subList.size() == k) {
            res.add(new ArrayList<Integer>(subList));
            return;
        }
        for (int i = index; i < 9; i++) {
            subList.add(nums[i]);
            backtrack(res, subList, remain-nums[i], i+1, k);
            subList.remove(subList.size()-1);
        }
    }
}
