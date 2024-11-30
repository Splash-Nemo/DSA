class ListNode{
    
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode(int val){
        this.val= val;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode temp= head;
        ListNode prev= null;
        ListNode next= temp.next;

        while(temp!=null){
            temp.next= prev;
            prev= temp;
            temp= next;

            if(next!=null)
            next= next.next;
        }

        return prev;
    }
}