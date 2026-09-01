// 2816. Double a Number Represented as a Linked List

class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = doubleUnit(head);

        if (carry != 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    public int doubleUnit(ListNode node) {
        if (node == null) {
            return 0;
        }
        int carry = doubleUnit(node.next);
        int multi = node.val * 2 + carry;
        node.val = multi % 10;
        return multi / 10;
    }
}
