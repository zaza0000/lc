package linkedList;

public class lc61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        int size = 0;
        int kk = k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        ListNode newHead;
        while(kk>0 && p1.next != null){
            kk--;
            size++;
            p1 = p1.next;
        }
        if(kk==0 && p1.next == null)
            return head;
        else if(kk==0){
            while(p1.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            newHead = p2.next;
            p2.next = null;
            p1.next = head;

            return newHead;
        }else{
            kk = k%size;
            if(kk == 0)
                return head;
            p1 = dummy;
            while(kk>0){
                kk--;
                p1 = p1.next;
            }

            while(p1.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
            newHead = p2.next;
            p2.next = null;
            p1.next = head;

            return newHead;
        }
    }
}
