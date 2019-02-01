package linkedList;

public class lc92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m==n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int start = m - 1;
        int length = n - m + 1;
        ListNode p1 = dummy;
        ListNode cur;
        ListNode p2 = null;
        while(start > 0){
            start--;
            p1 = p1.next;
        }
        cur = p1.next;
        ListNode subtail = cur;
        ListNode subhead = cur;
        while(length > 0){
            subhead = cur;
            ListNode temp = cur.next;
            cur.next = p2;
            p2 = cur;
            cur = temp;
            length--;
        }
        p1.next = subhead;
        subtail.next = cur;
        return dummy.next;
    }
}
