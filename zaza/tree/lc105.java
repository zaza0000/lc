package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursive
    Map<Integer, Integer> inHash;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder == null || preorder.length == 0)
            return root;
        inHash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inHash.put(inorder[i], i);
        }
        root = buildHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);

        return root;
    }

    private TreeNode buildHelper(int[] preorder, int[] inorder, int pl, int pr,
                                 int il, int ir) {
        if(pl > pr)
            return null;
        int sizeOfL = inHash.get(preorder[pl]) - il;
        TreeNode node = new TreeNode(preorder[pl]);
        TreeNode left = buildHelper(preorder, inorder, pl+1, pl+sizeOfL, il, il+sizeOfL-1);
        TreeNode right = buildHelper(preorder, inorder, pl+sizeOfL+1, pr, il+sizeOfL+1, ir);
        node.left = left;
        node.right = right;

        return node;
    }

    // iterative
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder==null || inorder==null || preorder.length!=inorder.length || preorder.length==0) { return null; }
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);  // the root of the entire tree
        s.addLast(root);  // also the current root
        for (int p=1, i=0; ;) {
            if (s.peekLast().val != inorder[i]) {  // current root's left subtree is not done
                TreeNode left = new TreeNode(preorder[p++]);
                s.peekLast().left = left;
                s.addLast(left);  // push into the stack, as the current root
            } else {  // current root's left subtree is done, should traverse its rightsubtree
                if (++i >= inorder.length) { break; }
                TreeNode curRoot = s.removeLast();
                if (!s.isEmpty() && s.peekLast().val==inorder[i]) { continue; }
                TreeNode right = new TreeNode(preorder[p++]);
                curRoot.right = right;
                s.addLast(right);
            }
        }
        return root;
    }


//    ArrayDeque is memory efficient since you don't have to keep track of next node unlike in Linked List.
//    ArrayDeque is Resizable-array implementation of the Deque interface. ...
//    This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.

}
