import java.util.Arrays;
import java.util.Scanner;

public class SearchOperations {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int n, choice, key, i;
        boolean found;

        // Array creation
        try (Scanner sc = new Scanner(System.in)) {
            // Array creation
            System.out.print("Enter size of array: ");
            n = sc.nextInt();
            
            System.out.println("Enter " + n + " elements:");
            for (i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Display array
            System.out.print("Array elements: ");
            for (i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            
            do {
                System.out.println("\n\n----- SEARCH MENU -----");
                System.out.println("1. Linear Search");
                System.out.println("2. Binary Search");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                
                switch (choice) {
                    
                    case 1 ->  { // Linear Search
                        System.out.print("Enter element to search: ");
                        key = sc.nextInt();
                        
                        found = false;
                        for (i = 0; i < n; i++) {
                            if (arr[i] == key) {
                                System.out.println("Element found at position " + i);
                                found = true;
                                break;
                            }
                        }
                        
                        if (!found)
                            System.out.println("Element not found.");
                    }
                    
                    case 2 ->  { // Binary Search
                        System.out.print("Enter element to search: ");
                        key = sc.nextInt();
                        
                        Arrays.sort(arr, 0, n); // sort array
                        
                        System.out.print("Sorted Array: ");
                        for (i = 0; i < n; i++)
                            System.out.print(arr[i] + " ");
                        
                        int low = 0, high = n - 1, mid;
                        found = false;
                        
                        while (low <= high) {
                            mid = (low + high) / 2;
                            
                            if (arr[mid] == key) {
                                System.out.println("\nElement found at position " + mid);
                                found = true;
                                break;
                            } else if (arr[mid] < key) {
                                low = mid + 1;
                            } else {
                                high = mid - 1;
                            }
                        }
                        
                        if (!found)
                            System.out.println("\nElement not found.");
                    }
                    
                    case 0 ->  {
                        System.out.println("Exiting program...");
                    }
                    
                    default -> System.out.println("Invalid choice.");
                }
                
            } while (choice != 0);
        }
    }
}