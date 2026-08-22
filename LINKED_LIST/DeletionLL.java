class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class DeletionLL {

    private static Node convertArr2LL(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 1. Delete Head: TC: O(1), SC: O(1)
    private static Node removeHead(Node head) {
        if (head == null)
            return null;
        head = head.next;
        return head;
    }

    // 2. Delete Tail: TC: O(N), SC: O(1)
    private static Node removeTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // 3. Delete K-th element (1-based index): TC: O(K), SC: O(1)
    private static Node removeK(Node head, int k) {
        if (head == null) return null;
        if (k == 1) return head.next;

        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // 4. Delete by Value: TC: O(N), SC: O(1)
    private static Node removeEl(Node head, int el) {
        if (head == null) return null;
        if (head.data == el) return head.next;

        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == el) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 8, 7 };
        Node head = convertArr2LL(arr);

        System.out.print("Original List: ");
        printLL(head);

        // Delete Tail
        head = removeTail(head);
        System.out.print("After Removing Tail: ");
        printLL(head);

        // Reset list for testing
        head = convertArr2LL(new int[]{12, 5, 8, 7});

        // Delete Head
        head = removeHead(head);
        System.out.print("After Removing Head: ");
        printLL(head);

        // Reset list for testing
        head = convertArr2LL(new int[]{12, 5, 8, 7});

        // Delete K-th element (e.g. k = 3 -> removes 8)
        head = removeK(head, 3);
        System.out.print("After Removing 3rd Element: ");
        printLL(head);

        // Reset list for testing
        head = convertArr2LL(new int[]{12, 5, 8, 7});

        // Delete element by value (e.g. value = 5)
        head = removeEl(head, 5);
        System.out.print("After Removing Element 5: ");
        printLL(head);
    }
}