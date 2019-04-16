/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        
        // push all nodes into the stack
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        
        // get the n-th node from the end
        for (int i = 1; i <= n; i++) {
            curr = stack.pop();
        }
        
        // the n-th node from the end is the head
        if (stack.isEmpty()) {
            return curr.next;
        }
        else {
            ListNode pre = stack.pop();
            pre.next = curr.next;
            return head;
        }
    }
}
