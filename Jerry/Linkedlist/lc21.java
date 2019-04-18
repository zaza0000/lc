/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        while (l1 != null && l2 != null) {
            ListNode next = l1.next;
            
            while (l1.val > l2.val && l2.next != null) {
                pre = l2;
                l2 = l2.next;
            }
            
            if (l1.val <= l2.val) {
                // insert l1 between pre and l2
                l1.next = l2;
                if (pre != null) {
                    pre.next = l1;
                }
                // update pre and l1
                pre = l1;
                l1 = next;
                
            }
            else { // l1 is larger than the last node in list 2
                l2.next = l1;
                break;
            }
            
        }
        
        return head;
    }

    /**
     * Result
     * Runtime: faster than 100.00%
     * Memory: less than 62.76%
     */
}