class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> solutions = new ArrayList();
        List<Integer> partSol = new ArrayList();
        dfs(n, k, 1, partSol, solutions);
        
        return solutions;
    }
    
    private void dfs(int target, int size, int currNum,
                     List<Integer> partSol, List<List<Integer>> solutions) {
        // size boundary reached
        if (partSol.size() == size) {
            // solution found
            if (target == 0) {
                List<Integer> solution = new ArrayList(partSol);
                solutions.add(solution);
            }
            
            return;
        }
        
        // deadend
        if (currNum > 9 || currNum > target) {
            return;
        }
        
        partSol.add(currNum);
        dfs(target - currNum, size, currNum + 1, partSol, solutions);
        partSol.remove(partSol.size() - 1);
        dfs(target, size, currNum + 1, partSol, solutions);
    }

    /**
     * Runtime: faster than 100.00%
     * Memory Usage: less than 100.00%
     */
}