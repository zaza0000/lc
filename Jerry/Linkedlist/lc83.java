/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode pre = head;
        ListNode curr = pre.next;
        
        while (curr != null) {
            if (curr.val == pre.val) {
                pre.next = curr.next;
                curr = curr.next;
            }
            else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
