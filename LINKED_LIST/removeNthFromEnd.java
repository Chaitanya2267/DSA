class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {return null;}
        int cnt = 0;
        ListNode temp = head;
        while(temp != null) {
            cnt++;
            temp = temp.next;
        }
        if(cnt == n) {return head.next; }
        int res = cnt - n;
        temp = head;
        while(temp != null) {
            res--;
            if(res == 0) {break;}
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}

// --------------------------------------------------------------
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        if (count == n) {
            return head.next;
        }

        int steps = count - n - 1;
        current = head;

        while (steps-- > 0) {
            current = current.next;
        }

        current.next = current.next.next;
        return head;
    }
}
// -----------------------------------------------------------------

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
// ------------------------------------------------------------------

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0 ; i < n; i++) fast = fast.next;
        if(fast == null) return head.next;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        return head;
    }
}
