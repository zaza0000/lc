/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode longer, shorter;
        if (lengthA >= lengthB) {
            longer = headA;
            shorter = headB;
        }
        else {
            longer = headB;
            shorter = headA;
        }
        
        // set longer to the same length as shorter
        int i = 0;
        while (i < Math.abs(lengthA - lengthB)) {
            longer = longer.next;
            i++;
        }
        
        // start comparing
        while (longer != null && longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return longer;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    /**
     * Result
     * Runtime: faster than 98.16%
     * Memory: less than 32.68%
     */
}