// 148. Sort List

class Solution {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        Collections.sort(arr);
        temp = head;
        for(int i = 0; i < arr.size(); i++) {
            temp.val = arr.get(i);
            temp = temp.next;
        }
        return head;
    }
}
// --------------------------------------------------------------------------------------------

class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;

        ListNode left = head;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        } else {
            curr.next = right;
        }

        return dummy.next;
    }
}
