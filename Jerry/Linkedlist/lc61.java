/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * The rotation can be seen as:
     *   1. Cut the list at the k-th node from the end
     *   2. Put the latter part to the front
     */
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        if (k == 0) {
            return head;
        }
        
        ListNode front = head, end = head;
        
        // set end as the k-th in the list
        int index = 1;
        while (index < k && end.next != null) {
            end = end.next;
            index++;
        }
        
        if (end.next == null) { // k is larger than the length of the linked list
            k = k % index; // by now index is the length of the linked list
            if (k == 0) {
                return head;
            }
            end = head;
            index = 1;
            while (index < k) {
                end = end.next;
                index++;
            }
        }
        
        // set front as the pre-node of the k-th node from the end
        // by now 0 < k < length of list
        while (end.next.next != null) {
            front = front.next;
            end = end.next;
        }
        
        // set end as the last node
        end = end.next;
        
        // rotate list
        ListNode newHead = front.next; // k-th node from the end
        front.next = null; // now front is the last node
        end.next = head;
        
        return newHead;
    }

    /**
     * Result
     * Runtime: faster than 100.00%
     * Memory: less than 5.18%
     */
}