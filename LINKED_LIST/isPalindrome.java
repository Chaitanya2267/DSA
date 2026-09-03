// 234. Palindrome Linked List

import java.util.Stack;

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        while (current != null) {
            if (current.val != stack.peek()) {
                return false;
            }
            stack.pop();
            current = current.next;
        }

        return true;
    }
}
// ---------------------------------------------------------------

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseLinkedList(slow.next);

        ListNode first = head;
        ListNode second = secondHalf;
        boolean palindrome = true;

        while (second != null) {
            if (first.val != second.val) {
                palindrome = false;
                break;
            }

            first = first.next;
            second = second.next;
        }

        slow.next = reverseLinkedList(secondHalf);

        return palindrome;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
