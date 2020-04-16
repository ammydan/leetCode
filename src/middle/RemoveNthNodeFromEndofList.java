package middle;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
// }
/**
 * We should notice there is no dumy head in the link so we should think of the situation the num==0.
 * Other solution: keep the distance of two pointer, when the last pointer arrive the end of null, the pre pointer is before the position
 * ***/
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        if(head.next==null&&n>0)return null;
        ListNode end=null,pos=null,pre=null;
        end = head;
        int num = 0;
        while(end!=null){
            num++;
            end=end.next;
        }
        num = num-n;
        pos = head;
        if(num==0)head = head.next;
        else{
            while(num-->0){
                pre=pos;
                pos = pos.next;
            }
            pre.next = pos.next;
        }

        return head;

    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList test = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        ListNode pos = head;
        pos.next = new ListNode(2);
        pos = pos.next;
        pos.next = new ListNode(3);
        pos = pos.next;
        pos.next = new ListNode(4);
        pos = pos.next;
        pos.next = new ListNode(5);

        test.removeNthFromEnd(head,2);
    }
}
