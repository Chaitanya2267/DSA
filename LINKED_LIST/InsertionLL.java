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

public class InsertionLL {

    private static Node convertArr2LL(int[] arr) {
        if(arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length ; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 1. Insert Head
    private static Node insertHead(Node head, int val) {
        return new Node(val, head);
    }

    // 2. Insert Tail
    private static Node insertTail(Node head, int val) {
        if(head == null) {
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    // 3. Insert at k-th position
    private static Node insertPosition(Node head, int el, int k) {
        if (head == null) {
            if (k == 1) return new Node(el);
            return null;
        }
        if (k == 1) {return new Node(el, head); }
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == (k - 1)) {
                Node newNode = new Node(el);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // 4. Insert before a value
    private static Node insertBeforeValue(Node head, int el, int val) {
        if (head == null) return null;
        if (head.data == val) {return new Node(el, head); }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                Node newNode = new Node(el);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 8, 7};
        Node head = convertArr2LL(arr);

        System.out.print("Original List: ");
        printLL(head);

        // 1. Insert at Head
        head = insertHead(head, 100);
        System.out.print("Insert 100 at Head: ");
        printLL(head);

        // 2. Insert at Tail
        head = insertTail(head, 50);
        System.out.print("Insert 50 at Tail: ");
        printLL(head);

        // 3. Insert at K-th Position (e.g., position 3)
        head = insertPosition(head, 25, 3);
        System.out.print("Insert 25 at Position 3: ");
        printLL(head);

        // 4. Insert before a specific value (e.g., before 8)
        head = insertBeforeValue(head, 99, 8);
        System.out.print("Insert 99 before Value 8: ");
        printLL(head);
    }
}