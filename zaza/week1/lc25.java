public class lc25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy; //start
        ListNode p2 = dummy.next; //end
        int count = 1;
        while(p2 != null){
            count++;
            p2 = p2.next;
            if(p2 == null)
                break;
            if(count == k){
                ListNode cur = p1.next;
                ListNode cNext = cur.next;
                ListNode end = p2.next;
                p2 = p2.next;
                while(cur != p2){
                    cur.next = end;
                    end = cur;
                    cur = cNext;
                    if(cNext != null)
                        cNext = cNext.next;
                }
                p1.next = end;
                while(count != 0){
                    p1 = p1.next;
                    count--;
                }
                count = 1;
            }
        }

        return dummy.next;
    }
}
