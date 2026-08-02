import java.util.Scanner;

class array {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter size of array: ");
            int size = sc.nextInt();

            int[] arr = new int[size];

            System.out.println("Enter integers: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("You Entered: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }

            System.out.println("Reverse Order: ");
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.println(arr[i]);
            }

            System.out.println("First element: " + arr[0]);
            System.out.println("Last element: " + arr[arr.length - 1]);

            int middleIndex = arr.length / 2;
            System.out.println("Middle element: " + arr[middleIndex]);
        }
    }
}
