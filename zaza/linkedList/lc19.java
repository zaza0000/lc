package linkedList;

public class lc19 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while(n>0){
            p1 = p1.next;
            n--;
        }
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;

        return dummy.next;
    }
}
