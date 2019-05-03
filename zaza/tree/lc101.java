package tree;

import java.util.LinkedList;
import java.util.Queue;

public class lc101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // recursively
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode l, TreeNode r) {
        if (l == null || r == null)
            return l == null && r == null;
        return l.val == r.val && helper(l.right, r.left) && helper(l.left, r.right);
    }

    // iteratively
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null)   //  <- diff
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            queue.add(t1.right);
            queue.add(t2.left);
            queue.add(t1.left);
            queue.add(t2.right);
        }
        return true;
    }

}

/*
    Queue:

    add       增加一个元索                  如果队列已满，则抛出一个IIIegaISlabEepeplian异常
　　remove     移除并返回队列头部的元素       如果队列为空，则抛出一个NoSuchElementException异常
　　element    返回队列头部的元素            如果队列为空，则抛出一个NoSuchElementException异常
　　offer      添加一个元素并返回true        如果队列已满，则返回false
　　poll       移除并返问队列头部的元素       如果队列为空，则返回null
　　peek       返回队列头部的元素            如果队列为空，则返回null
　　put        添加一个元素                 如果队列满，则阻塞
　　take       移除并返回队列头部的元素       如果队列为空，则阻塞
 */
