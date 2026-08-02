import java.util.Scanner;

class Queue {
    int[] arr;
    int front, rear;
    int capacity;

    Queue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = -1;
        rear = -1;
    }

    void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1)
                front = 0;
            arr[++rear] = x;
            System.out.println(x + " enqueued into queue");
        }
    }

    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(arr[front++] + " dequeued from queue");
        }
    }

    void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

public class QueueProgram {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            System.out.print("Enter size of queue: ");
            size = sc.nextInt();

            Queue q = new Queue(size);

            System.out.println("Enter " + size + " elements to enqueue:");
            for (int i = 0; i < size; i++) {
                int val = sc.nextInt();
                q.enqueue(val);
            }

            System.out.println("\nCurrent queue:");
            q.display();

            System.out.println("\nPerforming dequeue:");
            q.dequeue();

            System.out.println("\nAfter dequeue:");
            q.display();
        }
    }
}