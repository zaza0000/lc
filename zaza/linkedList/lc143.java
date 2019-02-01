package linkedList;

public class lc143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        ListNode tempHead;
        temp = head;
        size = (size-1)/2;
        while(size > 0){
            temp = temp.next;
            size--;
        }
        tempHead = temp.next;
        temp.next = null;
        tempHead = reverse(tempHead);
        head = combine(head, tempHead);
    }
    private ListNode combine(ListNode h1, ListNode h2){
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;
        ListNode newHead = h1;
        while(h1!=null && h2!=null){
            ListNode temp2 = h2.next;
            h2.next = h1.next;
            h1.next = h2;
            h2 = temp2;
            h1 = h1.next.next;
        }
        return newHead;
    }
    private ListNode reverse(ListNode h){
        if(h == null || h.next == null)
            return h;
        ListNode temp = reverse(h.next);
        h.next.next = h;
        h.next = null;
        return temp;
    }
}

// ****when the length of l1 and l2 is unknown
//    public ListNode combine(ListNode l1, ListNode l2) {
//        if(l1 == null)
//            return l2;
//        if(l2 == null)
//            return l1;
//        ListNode head = l1;
//        while(l1.next!=null && l2.next!=null){
//            ListNode temp = l2.next;
//            l2.next = l1.next;
//            l1.next = l2;
//            l2 = temp;
//            l1 = l1.next.next;
//        }
//        if(l2.next == null){
//            l2.next = l1.next;
//            l1.next = l2;
//        }
//        else if(l1.next == null){
//            l1.next = l2;
//        }
//        return head;
//    }