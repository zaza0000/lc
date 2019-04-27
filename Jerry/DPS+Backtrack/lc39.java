class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return solutions;
        }
        
        List<Integer> partSol = new ArrayList();
        dfs(candidates, target, 0, partSol, solutions);
        
        return solutions;
    }
    
    private void dfs(int[] candidates, int target, int start,
                     List<Integer> partSol, List<List<Integer>> solutions) {
        // solution found
        if (target == 0) {
            List<Integer> solution = new ArrayList(partSol);
            solutions.add(solution);
            return;
        }
        
        if (start == candidates.length) {
            return;
        }
        
        if (candidates[start] <= target) {
            partSol.add(candidates[start]);
            dfs(candidates, target - candidates[start], start, partSol, solutions);
            partSol.remove(partSol.size() - 1);
        }
        
        dfs(candidates, target, start + 1, partSol, solutions);
    }

    /**
     * Runtime: faster than 92.19%
     * Memory Usage: less than 64.68%
     */
}