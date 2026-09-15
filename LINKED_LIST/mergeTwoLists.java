// 21. Merge Two Sorted Lists

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> values = new ArrayList<>();

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null) {
            values.add(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            values.add(temp2.val);
            temp2 = temp2.next;
        }

        Collections.sort(values);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }
}
// ------------------------------------------------------------------------------------

