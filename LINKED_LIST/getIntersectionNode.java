public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
            if(t1 == t2) return t1;
            if(t1 == null) t1 = headB;
            if(t2 == null) t2 = headA;
        }
        return t1;
    }
}
// -----------------------------------------------------------------------------------
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        
        ListNode temp = headA;
        while (temp != null) {
            visitedNodes.add(temp);
            temp = temp.next;
        }
        
        temp = headB;
        while (temp != null) {
            if (visitedNodes.contains(temp)) {
                return temp; 
            }
            temp = temp.next;
        }
        
        return null;
    }
}
