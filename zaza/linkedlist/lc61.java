package linkedlist;

public class lc61 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;

        ListNode tail = head;
        int length = 1;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = length - (k%length);
        ListNode newHead = head;
        while(k > 1) {
            k--;
            newHead = newHead.next;
        }
        tail.next = head;
        ListNode temp = newHead;
        newHead = newHead.next;
        temp.next = null;

        return newHead;
    }
}
