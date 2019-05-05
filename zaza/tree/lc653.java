package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // set
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Set<Integer> hash = new HashSet<>();
        return preorder(root, k, hash);
    }

    private boolean preorder(TreeNode node, int k, Set<Integer> hash) {
        if (hash.contains(k-node.val))
            return true;
        hash.add(node.val);
        boolean flag = false;
        if (node.left != null)
            flag = preorder(node.left, k, hash);
        if (flag == true)
            return true;
        if (node.right != null)
            return preorder(node.right, k, hash);
        return false;
    }
    // improved:
//    if (root == null) {
//        return false;
//    } else if (set.contains(k - root.val)) {
//        return true;
//    }
//        set.add(root.val);
//        return findTarget(root.left, k, set) || findTarget(root.right, k, set);

    // two pointer
    public boolean findTarget2(TreeNode root, int k) {
        if (root == null)
            return false;
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
    }

}
