package linkedlist;

public class lc148 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;
        ListNode head2 = head;
        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            head2 = head2.next;
        }
        // first part (head, head2),  second part (head2+1, tail)
        p = head2;
        head2 = head2.next;
        p.next = null;

        return merge(sortList(head), sortList(head2));
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                p.next = head2;
                p = p.next;
                head2 = head2.next;
            } else {
                p.next = head1;
                p = p.next;
                head1 = head1.next;
            }
        }
        if (head1 != null) {
            p.next = head1;
        } else {
            p.next = head2;
        }

        return dummy.next;
    }
}
