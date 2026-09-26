// 2181. Merge Nodes in Between Zeros

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode originalHead = head;
        ListNode curr = head.next;
        int s = 0;
        while (curr != null) {
            if (curr.val == 0) {
                head.val = s;
                s = 0;
                if (curr.next != null) {
                    head = head.next;
                }
            }
            s += curr.val;
            curr = curr.next;
        }
        head.next = null;
        return originalHead;
    }
}
