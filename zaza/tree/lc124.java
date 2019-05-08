package tree;

public class lc124 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        int newSum = left + right + node.val;
        maxSum = Math.max(maxSum, newSum);
        return Math.max(left, right) + node.val;
    }

}
