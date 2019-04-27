package DFSandBacktrack;

import java.util.ArrayList;
import java.util.List;

public class lc78 {

    // backtrack
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;

        backtrack(new ArrayList<Integer>(), nums, res, 0);

        return res;
    }

    private void backtrack(List<Integer> subset, int[] nums, List<List<Integer>> res, int index) {
        res.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++) {
            if (subset.contains(nums[i]))
                continue;
            subset.add(nums[i]);
            backtrack(subset, nums, res, i+1);
            subset.remove(subset.size()-1);
        }
    }

    // Bitwise operation
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        int numOfSubset = (1 << nums.length);
        for (int i = 0; i < numOfSubset; i++) {
            List<Integer> subres = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1)
                    subres.add(nums[j]);
            }
            res.add(subres);
        }

        return res;
    }
}
