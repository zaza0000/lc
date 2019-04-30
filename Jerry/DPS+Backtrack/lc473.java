class Solution {
    // DFS
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 4 != 0) {
            return false;
        }
        
        int[] currLengths = new int[]{0, 0, 0, 0};
        return dfs(nums, 0, sum / 4, currLengths);
    }
    
    private boolean dfs(int[] nums, int index, int edgeLength, int[] currLengths) {
        // all matchsticks used
        if (index == nums.length) {
            return true;
        }
        
        for (int i = 0; i < 4; i++) {
            if (nums[index] + currLengths[i] <= edgeLength) {
                currLengths[i] += nums[index];
                if (dfs(nums, index + 1, edgeLength, currLengths)) {
                    return true;
                }
                currLengths[i] -= nums[index];
            }
        }
        
        return false;
    }

    /**
     * Runtime: faster than 34.80%
     * Memory Usage: less than 96.88%
     */
}