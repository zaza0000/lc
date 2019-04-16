package linkedlist;

public class lc141 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            else
                return false;
            slow = slow.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
