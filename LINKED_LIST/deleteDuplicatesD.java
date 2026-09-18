// 82. Remove Duplicates from Sorted List II

class Solution {
    public ListNode deleteDuplicatesD(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                if (prev != null) {
                    prev.next = curr;
                } else {
                    head = curr;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
