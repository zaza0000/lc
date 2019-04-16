package linkedlist;

// optimized - skip

public class lc147 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val >= pre.val) {
                cur = cur.next;
                pre = pre.next;
                continue;
            }
            ListNode temp = cur.next;
            pre.next = temp;
            ListNode temp2 = dummy;
            while (temp2.next.val < cur.val) {
                temp2 = temp2.next;
            }
            cur.next = temp2.next;
            temp2.next = cur;
            cur = temp;
        }

        return dummy.next;
    }
}
