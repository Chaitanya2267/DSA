// 138. Copy List with Random Pointer

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();

        // Create a copy of every node
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        // Connect next and random pointers
        temp = head;
        while (temp != null) {
            Node copyNode = map.get(temp);

            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }
}
// -----------------------------------------------------------------

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // Step 1: Insert copied nodes between original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        // Step 2: Assign random pointers to copied nodes
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            if (curr.random != null) {
                copy.random = curr.random.next;
            }
            curr = copy.next;
        }
        // Step 3: Separate the original list and the copied list
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            copyCurr.next = copy;
            copyCurr = copy;
            curr = curr.next;
        }
        return dummy.next;
    }
}
