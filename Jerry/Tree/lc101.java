/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return twoSymmetric(root.left, root.right);
    }
    
    private boolean twoSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        
        if (root1 == null || root2 == null) {
            return false;
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        
        return twoSymmetric(root1.left, root2.right) && twoSymmetric(root1.right, root2.left);
    }

    /**
     * Runtime: faster than 100.00%
     * Memory Usage: less than 50.91%
     */
}