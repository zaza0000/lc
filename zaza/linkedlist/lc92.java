package linkedlist;

public class lc92 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode dummy = new ListNode(0);
        int length = n - m;
        dummy.next = head;
        ListNode p = dummy;
        while (m > 1) {
            p = p.next;
            m--;
        }
        p.next = helper(p.next, length);

        return dummy.next;
    }

    // iteratively
    private ListNode helper(ListNode node, int num) {
        ListNode newHead = null;
        ListNode tail = null;
        if (num > 0) {
            num--;
            ListNode temp = node;
            node = node.next;
            temp.next = newHead;
            newHead = temp;
            tail = temp;
        }
        while (num >= 0) {
            num--;
            ListNode temp = node;
            node = node.next;
            temp.next = newHead;
            newHead = temp;
        }
        tail.next = node;

        return newHead;
    }

    // recursively
    ListNode p1;
    ListNode p2;

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode dummy = new ListNode(0);
        int length = n - m;
        dummy.next = head;
        ListNode p = dummy;
        while (m > 1) {
            p = p.next;
            m--;
        }
        p2 = p.next;
        p.next = helper2(p2, length);
        p2.next = p1;

        return dummy.next;
    }

    private ListNode helper2(ListNode node, int num) {
        if (node.next == null || num == 0) {
            p1 = node.next;
            return node;
        }
        ListNode newHead = helper2(node.next, --num);
        node.next.next = node;
        node.next = null;

        return newHead;
    }

}
