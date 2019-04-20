/*
// Definition for a Node.
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
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node newHead = new Node(head.val, null, null);
        Node ptr = newHead;
        Node curr = head.next;
        int length = 1;
        // deep copy all nodes and set all "next" pointers
        while (curr != null) {
            length++;
            Node newNode = new Node(curr.val, null, null);
            ptr.next = newNode;
            ptr = newNode;
            curr = curr.next;
        }
        
        curr = head;
        ptr = newHead;
        while (curr != null) {
            Node random = curr.random;
            if (random == null) {
                curr = curr.next;
                ptr = ptr.next;
                continue;
            }
            
            // get # of nodes behind random
            int behind = 0;
            while (random.next != null) {
                behind++;
                random = random.next;
            }
            
            // set ptr.random as the (length - behind)-th node
            random = newHead;
            for (int i = 0; i < length - behind - 1; i++) {
                random = random.next;
            }
            ptr.random = random;
            
            curr = curr.next;
            ptr = ptr.next;
        }
        
        return newHead;
    }

    /**
     * Result
     * Runtime: faster than 21.18%
     * Memory: less than 99.59%
     */
}