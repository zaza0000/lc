/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode ahead = new ListNode(0);
            ahead.next = head;
            ListNode next = ahead;
            while(next != null) {
                ListNode pre = next;
                ListNode tail = next;
                int count = 0;
                while(tail.next != null && count < k) {
                    count++;
                    tail = tail.next;
                }
                if (count < k) break;
                ListNode curr = pre.next;
                while(curr != tail) {
                    pre.next = curr.next;
                    curr.next = tail.next;
                    tail.next = curr;
                    curr = pre.next;
                }
                while (count > 0) {
                    next = next.next;
                    count--;
                }
            }
            return ahead.next;
        }
}