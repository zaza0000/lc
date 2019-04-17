/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // iteratively
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode next = head.next;
        head.next = null;
        
        while (next != null) {
            ListNode pre = head;
            head = next;
            next = head.next;
            head.next = pre;
        }
        
        return head;
    }

    // recursively
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode[] headNTail = helper(head);
        return headNTail[0];
    }
    
    private ListNode[] helper(ListNode head) {
        ListNode[] headNTail = new ListNode[2];
        
        // head is the last one in list
        if (head.next == null) {
            headNTail[0] = head;
            headNTail[1] = head;
            return headNTail;
        }

        headNTail = helper(head.next);
        head.next = null;
        headNTail[1].next = head;
        headNTail[1] = headNTail[1].next;
        
        return headNTail;
    }
}
