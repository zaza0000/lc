package DPSandBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(), nums, res, new boolean[nums.length]);

        return res;
    }

    private void backtrack(List<Integer> combination, int[] nums, List<List<Integer>> res, boolean[] visited) {
        if (combination.size() == nums.length) {
            res.add(new ArrayList<Integer>(combination));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == true || i > 0 && nums[i] == nums[i-1] && visited[i-1] == false) {
                    continue;
                }
                combination.add(nums[i]);
                visited[i] = true;
                backtrack(combination, nums, res, visited);
                combination.remove(combination.size()-1);
                visited[i] = false;
            }
        }

    }

}
