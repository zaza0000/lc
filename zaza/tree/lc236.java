package tree;

import java.util.Stack;

public class lc236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        return null;
    }

    // iterative
    class Pair{
        public TreeNode t;
        public int i;
        Pair(TreeNode t, int i) {
            this.t = t;
            this.i = i;
        }

        public int getValue() {
            return i;
        }

        public TreeNode getKey() {
            return t;
        }
    }
    TreeNode res = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        Stack<Pair> stack = new Stack<>();
        int depth = 0;
        int curDepth = 0;
        Pair pair = null;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                if (cur == p || cur == q) {
                    if (res == null) {
                        res = cur;
                        depth = curDepth+1;
                    }
                    else if (cur != res){
                        return res;
                    }
                }
                stack.push(new Pair(cur, curDepth+1));
                cur = cur.left;
                curDepth++;
            }
            if (!stack.isEmpty()) {
                pair = stack.pop();
                curDepth = pair.getValue();
                cur = pair.getKey();
                if (res != null && curDepth < depth){
                    depth = curDepth;
                    res = cur;
                }
                cur = cur.right;
            }
        }
        return res;
    }
}

// use map
//class Solution {
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        // Stack for tree traversal
//        Deque<TreeNode> stack = new ArrayDeque<>();
//
//        // HashMap for parent pointers
//        Map<TreeNode, TreeNode> parent = new HashMap<>();
//
//        parent.put(root, null);
//        stack.push(root);
//
//        // Iterate until we find both the nodes p and q
//        while (!parent.containsKey(p) || !parent.containsKey(q)) {
//
//            TreeNode node = stack.pop();
//
//            // While traversing the tree, keep saving the parent pointers.
//            if (node.left != null) {
//                parent.put(node.left, node);
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                parent.put(node.right, node);
//                stack.push(node.right);
//            }
//        }
//
//        // Ancestors set() for node p.
//        Set<TreeNode> ancestors = new HashSet<>();
//
//        // Process all ancestors for node p using parent pointers.
//        while (p != null) {
//            ancestors.add(p);
//            p = parent.get(p);
//        }
//
//        // The first ancestor of q which appears in
//        // p's ancestor set() is their lowest common ancestor.
//        while (!ancestors.contains(q))
//            q = parent.get(q);
//        return q;
//    }
//
//}
