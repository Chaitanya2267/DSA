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
