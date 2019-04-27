class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        if (nums == null || nums.length == 0) {
            return subsets;
        }
        
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList();
        dfs(nums, 0, subset, subsets);
        
        return subsets;
    }
    
    private void dfs(int nums[], int start, List<Integer> temp, List<List<Integer>> subsets) {
        if (start == nums.length) {
            List<Integer> subset = new ArrayList(temp);
            subsets.add(subset);
            return;
        }
        
        int next = start;
        while (next < nums.length && nums[next] == nums[start]) {
            next++;
        }
        
        for (int i = start; i <= next; i++) {
            dfs(nums, next, temp, subsets);
            temp.add(nums[start]);
        }
        
        for (int i = 0; i <= next - start; i++) {
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * Runtime: faster than 100.00%
     * Memory Usage: less than 42.25%
     */
}