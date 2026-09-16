// 23. Merge k Sorted Lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];

            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(arr);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
// -----------------------------------------------------------

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = merge2Lists(head, lists[i]);
        }

        return head;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
// -----------------------------------------------------------

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();

            temp.next = minNode;
            temp = temp.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
