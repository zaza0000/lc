package tree;

public class lc99 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode n1 = null;
    TreeNode n2 = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        inorderTraversal(node.left);
        if (pre != null) {
            if (pre.val > node.val) {
                if (n1 == null) {
                    n1 = pre;
                }
                if (n1 != null) {
                    n2 = node;
                }
            }
        }
        pre = node;
        inorderTraversal(node.right);
    }

}

// iterative:
// http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
