// 2095. Delete the Middle Node of a Linked List

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode temp = head;
        int n = 0;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        int res = n/2;
        temp = head;
        while(temp != null) {
            res--;
            if(res == 0) {
                // ListNode middle = temp.next;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}

// ---------------------------------------------------------------------------------------

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
