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
