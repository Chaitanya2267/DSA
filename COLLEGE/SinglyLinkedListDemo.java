public class SinglyLinkedListDemo {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static class SinglyLinkedList {
        Node head;

        // Traversal
        void traverse() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Insert at beginning
        void insertBegin(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Insert at end
        void insertEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        // Insert at specific position (1-based index)
        void insertAtPos(int data, int pos) {
            if (pos <= 0)
                return;
            Node newNode = new Node(data);
            if (pos == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node temp = head;
            for (int i = 1; temp != null && i < pos - 1; i++)
                temp = temp.next;
            if (temp == null)
                return;
            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Delete from beginning
        void deleteBegin() {
            if (head != null)
                head = head.next;
        }

        // Delete from end
        void deleteEnd() {
            if (head == null)
                return;
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head;
            while (temp.next.next != null)
                temp = temp.next;
            temp.next = null;
        }

        // Delete from specific position (1-based index)
        void deleteAtPos(int pos) {
            if (pos <= 0 || head == null)
                return;
            if (pos == 1) {
                head = head.next;
                return;
            }
            Node temp = head;
            for (int i = 1; temp != null && i < pos - 1; i++)
                temp = temp.next;
            if (temp == null || temp.next == null)
                return;
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert operations
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.traverse();

        list.insertBegin(5);
        list.traverse();

        list.insertAtPos(15, 3);
        list.traverse();

        // Delete operations
        list.deleteBegin();
        list.traverse();

        list.deleteEnd();
        list.traverse();

        list.deleteAtPos(2);
        list.traverse();
    }
}
