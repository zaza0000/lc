/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        
        ListNode front = head;
        ListNode end = front;
        
        while (front.next != null && front.next.next != null) {
            // set end as L_n-1
            while (end.next.next != null) {
                end = end.next;
            }
            
            // cut L_n from L_n-1
            ListNode next = end.next;
            end.next = null;
            end = next;
            
            // connect L_n to L_1
            next = front.next;
            front.next = end;
            
            // connect L_2 to L_n
            end.next = next;
            
            // reset front and end
            front = next;
            end = front;
        }
    }

    /**
     * Result
     * Runtime: faster than 5.04%
     * Memory: less than 74.16%
     */
}