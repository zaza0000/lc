package tree;

import java.util.LinkedList;
import java.util.Queue;

public class lc117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // levelorder
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            Node pre = null;
            while (levelSize > 0) {
                levelSize--;
                Node cur = queue.remove();
                if (cur.left == null && cur.right == null)
                    continue;
                if (pre != null){
                    if (cur.left != null) {
                        pre.next = cur.left;
                        pre = pre.next;
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        pre.next = cur.right;
                        pre = pre.next;
                        queue.add(cur.right);
                    }
                } else {
                    if (cur.left != null) {
                        pre = cur.left;
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        if (pre != null)
                            pre.next = cur.right;
                        pre = cur.right;
                        queue.add(cur.right);
                    }
                }

            }
            levelSize = queue.size();
        }
        return root;
    }

    // using linkedNode to make it O(1) space complexity
    public Node connect3(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node tail = dummy;
            while(cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

    // recursive
    public Node connect2(Node root) {
        if(root==null){
            return null;
        }
        Node dummy = new Node(-1, null, null, null);
        Node pre = dummy, cur = root;
        while(cur != null) {
            if(cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
            }
            if(cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
            cur = cur.next;
        }
        connect2(dummy.next);

        return root;
    }
}
