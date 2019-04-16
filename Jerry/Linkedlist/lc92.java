/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        
        ListNode curr = head;
        int index = 1;
        
        // get the m-th node
        while (index < m - 1) {
            curr = curr.next;
            index++;
        }
        ListNode mthPre = null, mth = null;
        if (m == 1) { // reverse from the start
            mth = curr;
        }
        else {
            mthPre = curr;
            curr = curr.next;
            mth = curr;
            index++;
        }
        
        // reverse from m-th to n-th
        ListNode next = curr.next;
        while (index < n) {
            ListNode pre = curr;
            curr = next;
            next = curr.next;
            curr.next = pre;
            index++;
        }
        
        mth.next = next;
        if (m == 1) { // reverse from the start
            return curr;
        }
        else {
            mthPre.next = curr;
            return head;
        }
    }
}