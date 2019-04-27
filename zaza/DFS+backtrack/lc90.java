package DFSandBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc90 {
    // recursively
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> subList, int[] nums, int index){
        ans.add(new ArrayList<>(subList));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i-1])
                continue;
            subList.add(nums[i]);
            backtrack(ans, subList, nums, i+1);
            subList.remove(subList.size()-1);
        }
    }

    // iteratively
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        int size = 1;
        for (int i = 0; i < nums.length; i++) {
            int startIndex = i > 0 && nums[i] == nums[i-1] ? size : 0;
            size = ans.size();
            for (int j = startIndex; j < size; j++) {
                List<Integer> subList = new ArrayList<>(ans.get(j));
                subList.add(nums[i]);
                ans.add(subList);
            }
        }

        return ans;
    }
}
