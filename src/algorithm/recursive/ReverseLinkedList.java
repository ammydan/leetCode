package algorithm.recursive;


public class ReverseLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    public ListNode reverseList(ListNode head){
        ListNode root = head;
        while(root.next!=null){
            root = root.next;
        }
        helper(head);
       return root;

    }
    private ListNode helper(ListNode current){
        if(current==null||current.next==null)return current;
        if(current.next.next==null){
            ListNode next = current.next;
            current.next.next = current;
            current.next = null;
            return next;
        }
        ListNode next = helper(current.next);
        current.next = next;
        next = helper(current);
        return next;
    }
}
