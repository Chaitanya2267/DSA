public class LinkedQueue {
    // Node structure
    class Node {
        int info;
        Node link;

        Node(int info) {
            this.info = info;
            this.link = null;
        }
    }

    private Node front = null; // Corresponds to FRONT
    private Node rear = null; // Corresponds to REAR
    private Node avail = null; // Corresponds to AVAIL (memory pool)

    
    public void insert(int item) {
        // 1. [Available space?] & 2. [Remove first node from AVAIL list]
        Node newNode;
        if (avail == null) {
            newNode = new Node(item);
        } else {
            newNode = avail;
            avail = avail.link;
        }

        // 3. Set INFO[NEW] := ITEM and LINK[NEW] := NULL
        newNode.info = item;
        newNode.link = null;

        // 4. Update FRONT and REAR
        if (front == null) {
            // If Q is empty, then ITEM is the first element
            front = rear = newNode;
        } else {
            // REAR points to the new node appended to the end
            rear.link = newNode;
            rear = newNode;
        }

        System.out.println("Inserted: " + item);
    }

    /**
     * Procedure 6.16: LINK_DELETE
     * Deletes the front element of the queue and returns it.
     */
    public Integer delete() {
        // 1. [Linked queue empty?]
        if (front == null) {
            System.out.println("UNDERFLOW");
            return null;
        }

        // 2. Set TEMP = FRONT
        Node temp = front;

        // 3. ITEM = INFO[TEMP]
        int item = temp.info;

        // 4. FRONT = LINK[TEMP]
        front = front.link;

        // Logical check: If front becomes null, rear must also be null
        if (front == null) {
            rear = null;
        }

        // 5. [Return the deleted node TEMP to the AVAIL list]
        temp.link = avail;
        avail = temp;

        return item;
    }

    // PEEK (FRONT ELEMENT)
    public Integer peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.info;
    }

    // CHECK EMPTY
    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        Node current = front;
        System.out.print("Queue (Front to Rear): ");
        while (current != null) {
            System.out.print(current.info + (current.link != null ? " -> " : ""));
            current = current.link;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);

        queue.display();

        System.out.println("Peek: " + queue.peek());

        System.out.println("Deleted: " + queue.delete());
        queue.display();

        System.out.println("Deleted: " + queue.delete());
        System.out.println("Deleted: " + queue.delete());

        // Underflow case
        System.out.println("Deleted: " + queue.delete());

        System.out.println("Is Empty: " + queue.isEmpty());
    }
}