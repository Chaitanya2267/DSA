public class LinkedStack {
    // Inner class representing a node in the list
    class Node {
        int info;
        Node link;

        Node(int info) {
            this.info = info;
            this.link = null;
        }
    }

    private Node top = null; // Corresponds to TOP
    private Node avail = null; // Corresponds to AVAIL (the free node pool)

    public void push(int item) {
        Node newNode;
        if (avail == null) { // memory is full
            newNode = new Node(item); // new memory dynamically
        } else {
            // [Remove first node from AVAIL list]
            newNode = avail;
            avail = avail.link;
        }

        // 3. Set INFO[NEW] := ITEM
        newNode.info = item;

        // 4. Set LINK[NEW] := TOP
        newNode.link = top;

        // 5. Set TOP := NEW
        top = newNode;

        System.out.println("Pushed: " + item);
    }

    public Integer pop() {
        if (top == null) {
            System.out.println("UNDERFLOW");
            return null;
        }

        int item = top.info;  // need to save before removing node

        Node temp = top; //store top temporarily
        top = top.link;  // 

        // 4. [Return deleted node to the AVAIL list]
        temp.link = avail;
        avail = temp;

        return item;
    }

    // PEEK
    public Integer peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return top.info;
    }

    // CHECK EMPTY
    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        Node current = top;
        System.out.print("Stack (Top to Bottom): ");
        while (current != null) {
            System.out.print(current.info + " -> ");
            current = current.link;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        stack.display();

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Underflow case
        System.out.println("Popped: " + stack.pop());

        System.out.println("Is Empty: " + stack.isEmpty());
    }
}