package linkedlist;

public class lc19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;    // pointer 1
        ListNode p2 = dummy;    // pointer 2
        while(n > 0) {
            n--;
            p2 = p2.next;
        }
        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;

        return dummy.next;
    }

}
