import java.util.Scanner;

class Stack {
    int[] arr;
    int top;
    int capacity;

    Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = x;
            System.out.println(x + " pushed into stack");
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(arr[top--] + " popped from stack");
        }
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

public class StackProgram {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int size;
            System.out.print("Enter size of stack: ");
            size = sc.nextInt();

            Stack s = new Stack(size);

            System.out.println("Enter " + size + " elements to push:");
            for (int i = 0; i < size; i++) {
                int val = sc.nextInt();
                s.push(val);
            }

            System.out.println("\nCurrent stack:");
            s.display();

            System.out.println("\nPerforming pop:");
            s.pop();

            System.out.println("\nAfter pop:");
            s.display();
        }
    }
}