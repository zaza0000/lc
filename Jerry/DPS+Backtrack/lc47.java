class Solution {
    // DFS
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> numList = new ArrayList();
        for (int i : nums) {
            numList.add(i);
        }
        result = dps(numList);
        
        return result;
    }
    
    private List<List<Integer>> dps(List<Integer> numList) {
        List<List<Integer>> result = new ArrayList();
        if (numList == null || numList.size() == 0) {
            return result;
        }
        
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < numList.size(); i++) {
            int num = numList.remove(i);
            
            if(seen.contains(num)) {
                numList.add(i, num);
                continue;
            }
            seen.add(num);
            
            List<List<Integer>> subLists = dps(numList);
            if (subLists.size() == 0) {
                subLists.add(new ArrayList());
            }
            for (List list : subLists) {
                list.add(0, num);
                result.add(list);
            }
            
            numList.add(i, num);
        }
        
        return result;
    }

    /**
     * Runtime: faster than 29.62%
     * Memory Usage: less than 87.48%
     */
}