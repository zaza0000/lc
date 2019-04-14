package linkedlist;

public class lc206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //iteratively
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;
    }

    //recursively
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

}
