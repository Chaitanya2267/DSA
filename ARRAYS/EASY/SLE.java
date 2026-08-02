// second largest element in array without sorting
import java.util.*;

public class SLE {
    public static int SecondLargestElement_bru(int[] arr, int n) {
        Arrays.sort(arr);
        int largest = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                return arr[i];
            }
        }
        return -1;
    } // O(nlogn + n) & O(1)

    public static int SecondLargestElement_bet(int[] arr, int n) {
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        int Slargest = Integer.MIN_VALUE; // -1
        for (int i = 0; i < n; i++) {
            if (arr[i] != largest && arr[i] > Slargest) {
                Slargest = arr[i];
            }
        }
        return (Slargest == Integer.MIN_VALUE) ? -1 : Slargest;
    } // O(2n) -> O(n) & O(1)

    public static int SecondLargestElement_opt(int[] arr, int n) {
        int largest = arr[0];
        int Slargest = Integer.MIN_VALUE; //-1

        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                Slargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > Slargest) {
                Slargest = arr[i];
            }
        }
        return (Slargest == Integer.MIN_VALUE) ? -1 : Slargest;
    } // O(n) & O(1)

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 7, 0, 1};
        int n = arr.length;

        System.out.println("Second largest (Brute Force): " + SecondLargestElement_bru(arr.clone(), n));
        System.out.println("Second largest (Better): " + SecondLargestElement_bet(arr, n));
        System.out.println("Second largest (Optimal): " + SecondLargestElement_opt(arr, n));
    }
}


/* ternary operator
Condition: Slargest == Integer.MIN_VALUE

Slargest was initialized as Integer.MIN_VALUE (the smallest possible integer in Java, i.e., -2147483648).

If no valid second largest element was found, Slargest will still be Integer.MIN_VALUE.

If true → return -1

This is a signal that there is no second largest element (for example, if all elements in the array are equal).

If false → return Slargest

This means a valid second largest element was found, so return it.
*/