package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // iterative
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<Integer>());
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.remove();
                res.get(level).add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return res;
    }

    //recursive
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder2(TreeNode root) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int level) {
        if (res.size() == level)
            res.add(new ArrayList<>());
        res.get(level).add(node.val);
        if(node.left != null)
            helper(node.left, level+1);
        if(node.right != null)
            helper(node.right, level+1);
    }
}
