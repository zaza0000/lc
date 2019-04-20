/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = 0;
        ListNode curr = head;
        // get the length of list
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        int i = 0;
        curr = head;
        // split list into 2 lists
        while (i < length / 2 - 1) {
            curr = curr.next;
            i++;
        }
        ListNode l2 = curr.next;
        curr.next = null;
        head = sortList(head);
        l2 = sortList(l2);
        head = mergeSorted(head, l2);
        
        return head;
    }
    
    private ListNode mergeSorted(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
        }
        else {
            head = l2;
        }
        
        ListNode pre = null;
        while (l1 != null) {
            ListNode next = l1.next;
            while (l2 != null && l1.val > l2.val) {
                pre = l2;
                l2 = l2.next;
            }
            
            l1.next = l2;
            if (pre != null) {
                pre.next = l1;
            }
            pre = l1;
            
            l1 = next;
        }
        
        return head;
    }

    /**
     * Result
     * Runtime: faster than 97.70%
     * Memory: less than 90.14%
     */
}