package algorithm.doublePointers;
/**
 * 142 middle
 * */
public class LinkedListCycke2 {
    class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)break;
        }
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
