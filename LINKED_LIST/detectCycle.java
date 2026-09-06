// 142. Linked List Cycle II
// Starting point of loop in a Linked List

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while(head != null) {
            if(visited.contains(head)) { return head; }
            visited.add(head);
            head = head.next;
        }

        return null;
    }
}

// -------------------------------------------------------------------------

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
