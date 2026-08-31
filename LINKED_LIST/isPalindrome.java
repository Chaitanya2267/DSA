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
