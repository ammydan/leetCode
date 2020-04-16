package middle;


class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode theNext = result;
        int flow = 0;
        while(l1!=null || l2!=null){
            int x = l1==null?0:l1.val;
            int y = l2==null?0:l2.val;
            int partResult = x+y+flow;
            flow = partResult/10;
            theNext.next = new ListNode(partResult%10);
            theNext = theNext.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(flow!=0){
            theNext.next = new ListNode(flow);
        }

        return result.next;
    }
}

