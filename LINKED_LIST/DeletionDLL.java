class Node {
    int data;
    Node next;
    Node prev;

    Node(int data1, Node next1, Node prev1) {
        this.data = data1;
        this.next = next1;
        this.prev = prev1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.prev = null;
    }
}

public class DeletionDLL {

    // Convert array to Doubly Linked List
    private static Node convertArr2DLL(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    // Print Doubly Linked List
    private static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // 1. Delete Head
    private static Node deleteHead(Node head) {
        if (head == null)
            return null;

        if (head.next == null)
            return null;

        Node prev = head;
        head = head.next;

        head.prev = null;
        prev.next = null;

        return head;
    }

    // 2. Delete Tail
    private static Node deleteTail(Node head) {
        if (head == null)
            return null;

        if (head.next == null)
            return null;

        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        Node newTail = tail.prev;

        newTail.next = null;
        tail.prev = null;

        return head;
    }

    // 3. Delete Kth Element
    private static Node deleteKthElement(Node head, int k) {
        if (head == null || k <= 0)
            return head;

        int cnt = 0;
        Node kNode = head;

        // Find kth node
        while (kNode != null) {
            cnt++;

            if (cnt == k)
                break;

            kNode = kNode.next;
        }

        // K is greater than the length
        if (kNode == null)
            return head;

        Node prev = kNode.prev;
        Node front = kNode.next;

        // Kth node is the head
        if (prev == null)
            return deleteHead(head);

        // Kth node is the tail
        if (front == null)
            return deleteTail(head);

        // Middle node
        prev.next = front;
        front.prev = prev;

        kNode.next = null;
        kNode.prev = null;

        return head;
    }

    // 4. Delete a given node
    private static void deleteNode(Node temp) {
        if (temp == null)
            return;

        Node prev = temp.prev;
        Node front = temp.next;

        // If temp is the only node
        if (prev == null && front == null) {
            return;
        }

        // If temp is the tail
        if (front == null) {
            prev.next = null;
            temp.prev = null;
            return;
        }

        // If temp is the head
        if (prev == null) {
            front.prev = null;
            temp.next = null;
            return;
        }

        // If temp is a middle node
        prev.next = front;
        front.prev = prev;

        temp.next = null;
        temp.prev = null;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        Node head = convertArr2DLL(arr);

        System.out.print("Original DLL: ");
        printLL(head);

        // 1. Delete Head
        head = deleteHead(head);

        System.out.print("After deleting head: ");
        printLL(head);

        // 2. Delete Tail
        head = deleteTail(head);

        System.out.print("After deleting tail: ");
        printLL(head);

        // 3. Delete 2nd element
        head = deleteKthElement(head, 2);

        System.out.print("After deleting 2nd element: ");
        printLL(head);

        // 4. Delete a given node
        // Current list: 20 40
        if (head != null && head.next != null) {
            deleteNode(head.next);
        }

        System.out.print("After deleting given node: ");
        printLL(head);
    }
}