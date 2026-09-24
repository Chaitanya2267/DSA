// 92. Reverse Linked List II

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        int i = 1;

        while (curr != null && i != left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode pointerToStart = prev;
        ListNode start = curr;
        prev = null;

        while (curr != null && i <= right) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        start.next = curr;
        if (pointerToStart != null) {
            pointerToStart.next = prev;
        } else {
            return prev;
        }
        return head;
    }
}
