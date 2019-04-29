class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        StringBuilder sb = new StringBuilder();
        dfs(n, n, sb, combinations);
        
        return combinations;
    }
    
    private void dfs(int open, int close, StringBuilder sb, List<String> combinations) {
        // combination found
        if (open == 0 && close == 0) {
            String combination = sb.toString();
            combinations.add(combination);
            return;
        }
        
        if (open > 0) {
            sb.append('(');
            dfs(open - 1, close, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close > open) {
            sb.append(')');
            dfs(open, close - 1, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * Runtime: faster than 96.61%
     * Memory Usage: less than 8.98%
     */
}