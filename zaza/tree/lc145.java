package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursively
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node) {
        if (node.left != null) {
            helper(res, node.left);
        }
        if (node.right != null) {
            helper(res, node.right);
        }
        res.add(node.val);
    }

    // iteratively
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();  // or deque or Stack<Integer> st = new Stack<Integer>();
        LinkedList<Integer> output = new LinkedList<>();
        //List<Integer> res = new LinkedList<>();
        //((LinkedList<Integer>) res).addFirst(0)
        //((LinkedList<Integer>) res).pollLast();
        if (root == null) {
            return output;
        }
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                output.addFirst(p.val);   //   <--- key point
                stack.add(p);
                p = p.right;
            }
            if (!stack.isEmpty()) {
                p = stack.pollLast();
                p = p.left;
            }
        }
        return output;
    }
    // inorder, iteratively
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> output = new LinkedList<>();
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode p = root;
//        while (!stack.isEmpty() || p != null) {
//            while (p != null) {
//                stack.push(p);
//                p = p.left;
//            }
//            if (!stack.isEmpty()) {
//                p = stack.pop();
//                output.add(p.val);
//                p = p.right;
//            }
//        }
//        return output;
//    }

    // preorder, iteratively
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> output = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode p = root;
//        while (!stack.isEmpty() || p != null) {
//            while (p != null) {
//                stack.push(p);
//                output.add(p.val);
//                p = p.left;
//            }
//            if (!stack.isEmpty()) {
//                p = stack.pop();
//                p = p.right;
//            }
//        }
//        return output;
//    }
    // not using addFirst()
//    public void postOrderTraversalbyLoop(Node node){
//        Stack<Node> stack = new Stack<>();
//        Node p = node,prev = node;
//        while(p!=null || !stack.isEmpty()){
//            while(p!=null){
//                stack.push(p);
//                p = p.getLeft();
//            }
//            if(!stack.isEmpty()){
//                Node temp = stack.peek().getRight();
//                if(temp == null||temp == prev){
//                    p = stack.pop();
//                    checkCurrentNode(p);
//                    prev = p;
//                    p = null;
//                }else{
//                    p = temp;
//                }
//            }
//        }
//    }

}
