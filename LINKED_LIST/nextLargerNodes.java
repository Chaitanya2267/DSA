// 1019. Next Greater Node In Linked List

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int n = list.size();
        int[] ans = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && list.get(i) > list.get(st.peek())) {
                int previous = st.pop();
                ans[previous] = list.get(i);
            }
            st.push(i);
        }
        return ans;
    }
}
