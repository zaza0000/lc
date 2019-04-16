package linkedlist;

import java.util.HashMap;
import java.util.Map;

// optimized - space O(1), a-a'-b-b'-c-c'

public class lc138 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    Map<Node, Node> hash;

    //iteratively
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        hash = new HashMap<Node, Node>();
        Node dummy = new Node();
        dummy.next = helper(head);

        return dummy.next;
    }

    private Node helper(Node n) {
        Node head = n;
        Node newNode;
        while (n != null){
            if (hash.containsKey(n)) {
                newNode = hash.get(n);
            } else {
                newNode = new Node(n.val, null, null);
                hash.put(n, newNode);
            }
            if (hash.containsKey(n.next)) {
                newNode.next = hash.get(n.next);
            } else {
                if (n.next != null){
                    hash.put(n.next, new Node(n.next.val, null, null) );
                    newNode.next = hash.get(n.next);
                } else{
                    newNode.next = null;
                }
            }
            if (hash.containsKey(n.random)) {
                newNode.random = hash.get(n.random);
            } else {
                if (n.random != null) {
                    hash.put(n.random, new Node(n.random.val, null, null));
                    newNode.random = hash.get(n.random);
                } else {
                    newNode.random = null;
                }
            }
            n = n.next;
            newNode = newNode.next;
        }

        return hash.get(head);
    }

    // recursively
    //Map<Node, Node> hash = new HashMap<Node, Node>();
    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;

        Node newHead;
        if (hash.containsKey(head))
            return hash.get(head);

        newHead = new Node(head.val, null, null);
        hash.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);

        return newHead;
    }

    // space O(1)

}
