class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList();
        if (candidates == null || candidates.length == 0) {
            return solutions;
        }
        
        Arrays.sort(candidates);
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
        
        // dead end
        if (start == candidates.length) {
            return;
        }
        
        if (candidates[start] <= target) {
            partSol.add(candidates[start]);
            dfs(candidates, target - candidates[start], start + 1, partSol, solutions);
            partSol.remove(partSol.size() - 1);
        }
        
        int next = start;
        while (next < candidates.length && candidates[next] == candidates[start]) {
            next++;
        }
        dfs(candidates, target, next, partSol, solutions);
    }

    /**
     * Runtime: faster than 95.13%
     * Memory Usage: less than 38.95%
     */
}