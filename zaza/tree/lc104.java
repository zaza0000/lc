package tree;
import javafx.util.Pair;

import java.util.LinkedList;

public class lc104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursively
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    /*
    Time complexity : we visit each node exactly once, thus the time complexity is
    \mathcal{O}(N)O(N), where NN is the number of nodes.

    Space complexity : in the worst case, the tree is completely unbalanced,
    e.g. each node has only left child node, the recursion call would occur
    N times (the height of the tree), therefore the storage to keep the call
    stack would be \mathcal{O}(N)O(N). But in the best case (the tree is
    completely balanced), the height of the tree would be \log(N)log(N).
    Therefore, the space complexity in this case would be \mathcal{O}(\log(N))O(log(N)).

     */

    // iteratively
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair(root, 1));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pollLast();
            root = cur.getKey();
            int curDepth = cur.getValue();
            if(root != null) {
                maxDepth = Math.max(maxDepth, curDepth);
                stack.add(new Pair(root.left, curDepth+1));
                stack.add(new Pair(root.right, curDepth+1));
            }
        }
        return maxDepth;
    }
    // or we could use two stack instead of using pair
    // or bfs
}
