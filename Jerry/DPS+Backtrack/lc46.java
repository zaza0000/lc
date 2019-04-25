class Solution {
	// DPS
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        // edge case
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> numList = new ArrayList();
        for (int i : nums) {
            numList.add(i);
        }
        result = permute(numList);
        return result;
    }
    
    
    private List<List<Integer>> permute(List<Integer> numList) {
        List<List<Integer>> result = new ArrayList();
        
        // edge case
        if (numList == null || numList.size() == 0) {
            return result;
        }
        
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.remove(i);
            List<List<Integer>> subLists = permute(numList);
            
            if (subLists.size() == 0) {
                subLists.add(new ArrayList());
            }
            
            for (List subList : subLists) {
                subList.add(0, num);
                result.add(subList);
            }
            
            numList.add(i, num);
        }
        
        return result;
    }

    /**
     * Runtime: faster than 70.27%
     * Memory Usage: less than 49.11%
     */
}