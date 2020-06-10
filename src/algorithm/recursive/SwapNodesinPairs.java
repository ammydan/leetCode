package algorithm.recursive;

public class SwapNodesinPairs {
    private class ListNode{
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)return head;
        head.next = head.next.next;
        head.next.next = head;
        swap(head);
        return head.next;
    }
    private void swap(ListNode head){
        if(head==null|head.next==null||head.next.next==null)return;
        ListNode a = head.next;
        ListNode b = a.next;
        a.next = b.next;
        head.next = b;
        b.next = a;
        swap(a);
    }

    public static void main(String[] args) {
        SwapNodesinPairs test = new SwapNodesinPairs();

    }
}
