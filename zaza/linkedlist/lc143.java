package linkedlist;

public class lc143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        // split
        ListNode p1 = head;
        int length = 1;
        while (p1 != null) {
            p1 = p1.next;
            length++;
        }
        length = (length + 1) / 2 - 1;
        ListNode head2 = head;
        while (length > 0) {
            length--;
            head2 = head2.next;
        }
        ListNode temp = head2;
        head2 = head2.next;
        temp.next = null;
        //reverse
        head2 = helper(head2);
        //combine
        p1 = head;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            temp = p1.next;
            p1.next = p2;
            p1 = temp;
            temp = p2.next;
            p2.next = p1;
            p2 = temp;
        }
    }

    private ListNode helper(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = helper(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
