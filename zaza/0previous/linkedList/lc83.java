package linkedList;

public class lc83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy.next;
        ListNode p2 = dummy.next;
        while(p2 != null){
            while(p1 != null && p1.val == p2.val){
                p1 = p1.next;
            }
            p2.next = p1;
            p2 = p1;
        }
        return dummy.next;
    }
}
