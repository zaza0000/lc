package DPSandBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1.how we can convert a collection to an ArrayList (or deepcopy). 2.contains, add, remove
// Array to ArrayList: new ArrayList<Element>(Arrays.asList(array))
// ArrayList to Array: arrayList.toArray()

public class lc46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        backtrack(new ArrayList<Integer>(), nums, res);

        return res;
    }

    private void backtrack(List<Integer> combination, int[] nums, List<List<Integer>> res) {
        if (combination.size() == nums.length) {
            res.add(new ArrayList<Integer>(combination));
        } else {
            for (int num : nums) {
                if (combination.contains(num))
                    continue;
                combination.add(num);
                backtrack(combination, nums, res);
                combination.remove(combination.size() - 1);
            }
        }
    }

}
