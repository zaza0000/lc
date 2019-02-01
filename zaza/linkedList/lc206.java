package linkedList;

public class lc206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Iterative
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = null;
        while(p1 != null){
            ListNode temp = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = temp;
        }
        return p2;
    }

    //Recursive
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p1;
    }
}
