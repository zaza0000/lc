package linkedList;

public class lc141 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null){
            if(slow == fast)
                return true;
            fast = fast.next;
            if(fast == null)
                return false;
            else
                fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}
