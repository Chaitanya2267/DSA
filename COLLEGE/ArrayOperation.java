import java.util.Scanner;

public class ArrayOperation {
    public static void main(String[] args) {
        int[] arr = new int[50];
        arr[0] = 20;
        arr[1] = 30;
        arr[2] = 52;
        arr[3] = 47;
        arr[4] = 60;

        int n = 5;
        int choice, pos, value, key, i;
        boolean found;
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("array operation");
                System.out.println("1.insert element");
                System.out.println("2.delete element");
                System.out.println("3.traverse array");
                System.out.println("4.search element");
                System.out.println("5.update element");
                System.out.println("0.exit");
                System.out.println("enter your choice");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> { // insertion
                        System.out.println("enter position");
                        pos = sc.nextInt();
                        System.out.println("enter value: ");
                        value = sc.nextInt();

                        for (i = n; i > pos; i--) {
                            arr[i] = arr[i - 1];
                        }
                        arr[pos] = value;
                        n++;

                        System.out.println("element inserted successfully. \n updated array: ");
                        for (i = 0; i < n; i++) {
                            System.out.println(arr[i] + " ");
                        }
                    }
                    case 2 -> { // deletion
                        System.out.println("enter position to delete: ");
                        pos = sc.nextInt();

                        for (i = pos; i < n - 1; i++) {
                            arr[i] = arr[i + 1];
                        }
                        n--;

                        System.out.println("element deleted successfully. \n updated array: ");
                        for (i = 0; i < n; i++) {
                            System.out.println(arr[i] + " ");
                        }
                    }
                    case 3 -> { // traversal
                        System.out.println("array elements: ");
                        for (i = 0; i < n; i++) {
                            System.out.println(arr[i] + " ");
                        }
                    }
                    case 4 -> { // searching
                        System.out.println("enter element to search: ");
                        key = sc.nextInt();
                        found = false;

                        for (i = 0; i < n; i++) {
                            if (arr[i] == key) {
                                System.out.println("element found st position: " + i);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("element not found.");
                        }
                    }
                    case 5 -> { // updating
                        System.out.println("enter position to update: ");
                        pos = sc.nextInt();
                        System.out.println("enter new value: ");
                        value = sc.nextInt();

                        arr[pos] = value;
                        System.out.println("element updated successfully. \n updated array: ");
                        for (i = 0; i < n; i++) {
                            System.out.println(arr[i] + " ");
                        }
                    }
                    case 0 -> {
                        System.out.println("exit the program");
                    }
                    default -> {
                        System.out.println("invalid choice!");
                    }

                }
            } while (choice != 0);
        }
    }
}
