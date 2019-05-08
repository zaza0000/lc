package tree;

public class lc543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return diameter;
        helper(root);
        return diameter-1;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        diameter = Math.max(diameter, left+right+1);
        return Math.max(left, right) + 1;
    }
}

// two way to store the depth of node:
// 1
//    Map<TreeNode,Integer> nodePathCountMap = new HashMap<>();
// 2
// using pair