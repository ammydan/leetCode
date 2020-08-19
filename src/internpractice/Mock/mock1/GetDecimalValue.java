package internpractice.Mock.mock1;


public class GetDecimalValue {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public int getDecimalValue(ListNode head){
        int sum = head.val;
        while(head.next!=null){
            ListNode temp = head.next;
            sum = sum*2+temp.val;
            head = temp;
        }
        return sum;
    }
}
