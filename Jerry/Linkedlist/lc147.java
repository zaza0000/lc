/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode pre = null;
            ListNode newNext = next.next;
            ListNode curr = head;
            while (curr.val <= next.val && curr.next != null) {
                pre = curr;
                curr = pre.next;
            }
            if (curr.val > next.val) {
                next.next = curr;
                if (pre != null) {
                    pre.next = next;
                }
                else {
                    head = next;
                }
            }
            else {
                curr.next = next;
                next.next = null;
            }
            next = newNext;
        }
        
        return head;
    }

    /**
     * Result
     * Runtime: faster than 57.50%
     * Memory: less than 54.94%
     */
}