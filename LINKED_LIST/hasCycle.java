public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        HashMap<Node, Integer> mpp = new HashMap<>();
        while(temp != null) {
            if(mpp.containsKey(temp)){ return true; }
            mpp.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }
}

// ------------------------------------------------------------

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) { return true; }
        }
        return false;
    }
}
