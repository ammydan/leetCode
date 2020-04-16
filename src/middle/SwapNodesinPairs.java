package middle;

/**
 * When we run the next() function, the first thing we should worry about is whether the pointer pointing to null.
 * ***/
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null)return head;
        if(head.next==null)return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre1, pre2, pos;
        pre1 = dummy;
        pre2 = pre1.next;
        pos = pre2.next;
        while(pos!=null){
            pre2.next = pos.next;
            pos.next = pre2;
            pre1.next = pos;
            pre1 = pre2;
            pre2 = pre2.next;
            if(pre2==null)break;
            pos = pre2.next;
        }
        return dummy.next;
    }
}
