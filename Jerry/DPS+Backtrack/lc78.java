class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> subset = new ArrayList();
        dfs(nums, 0, subset, result);
        return result;
    }
    
    private void dfs(int[] nums, int start, List<Integer> subset, List<List<Integer>> subsets) {
        if (start == nums.length) {
            subsets.add(subset);
            return;
        }
        
        List<Integer> copy = new ArrayList(subset);
        copy.add(nums[start]);
        dfs(nums, start + 1, subset, subsets);
        dfs(nums, start + 1, copy, subsets);
    }

    /**
     * Runtime: faster than 100.00%
     * Memory Usage: less than 10.93%
     */
}