public class lc124 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode n){
        if(n == null)
            return 0;
        int left = Math.max(0, dfs(n.left));
        int right = Math.max(0, dfs(n.right));
        ans = Math.max(ans, left + n.val + right);
        return n.val + Math.max(left, right);
    }
}
