/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
