public class DoublyLinkedListDemo {
    static class DNode {
        int data;
        DNode prev, next;

        DNode(int d) {
            data = d;
            prev = next = null;
        }
    }

    static class DoublyLinkedList {
        DNode head;

        // Traversal forward
        void traverseForward() {
            DNode temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Insert at beginning
        void insertBegin(int data) {
            DNode newNode = new DNode(data);
            if (head != null) {
                newNode.next = head;
                head.prev = newNode;
            }
            head = newNode;
        }

        // Insert at end
        void insertEnd(int data) {
            DNode newNode = new DNode(data);
            if (head == null) {
                head = newNode;
                return;
            }
            DNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }

        // Insert at specific position (1-based index)
        void insertAtPos(int data, int pos) {
            if (pos <= 0)
                return;
            DNode newNode = new DNode(data);
            if (pos == 1) {
                if (head != null) {
                    newNode.next = head;
                    head.prev = newNode;
                }
                head = newNode;
                return;
            }
            DNode temp = head;
            for (int i = 1; temp != null && i < pos - 1; i++)
                temp = temp.next;
            if (temp == null)
                return;
            newNode.next = temp.next;
            if (temp.next != null)
                temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }

        // Delete from beginning
        void deleteBegin() {
            if (head == null)
                return;
            head = head.next;
            if (head != null)
                head.prev = null;
        }

        // Delete from end
        void deleteEnd() {
            if (head == null)
                return;
            if (head.next == null) {
                head = null;
                return;
            }
            DNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.prev.next = null;
        }

        // Delete from specific position (1-based index)
        void deleteAtPos(int pos) {
            if (pos <= 0 || head == null)
                return;
            if (pos == 1) {
                head = head.next;
                if (head != null)
                    head.prev = null;
                return;
            }
            DNode temp = head;
            for (int i = 1; temp != null && i < pos; i++)
                temp = temp.next;
            if (temp == null)
                return;
            if (temp.prev != null)
                temp.prev.next = temp.next;
            if (temp.next != null)
                temp.next.prev = temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert operations
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.traverseForward();

        list.insertBegin(5);
        list.traverseForward();

        list.insertAtPos(15, 3);
        list.traverseForward();

        // Delete operations
        list.deleteBegin();
        list.traverseForward();

        list.deleteEnd();
        list.traverseForward();

        list.deleteAtPos(2);
        list.traverseForward();
    }
}
