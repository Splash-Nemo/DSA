import java.util.*;

class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}

// Using HashSet
class Solution1 {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return false;

        HashSet<ListNode> abc = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {
            if (abc.contains(temp))
                return true;

            abc.add(temp);
            temp = temp.next;
        }

        return false;
    }
}

// 2-pointers
class Solution2 {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}