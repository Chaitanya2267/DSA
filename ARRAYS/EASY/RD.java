// remove duplicates in-place from array

import java.util.TreeSet;

public class RD {

    // Brute Force Approach (using TreeSet)
    public static int removeDuplicates_bru(int[] arr, int n) {
        TreeSet<Integer> set = new TreeSet<>();

        // Add all elements to the set (unique + sorted)
        for (int value : arr) {
            set.add(value);
        }

        // Put unique elements back into the array
        int index = 0;
        for (int value : set) {
            arr[index] = value;
            index++;
        }

        // Return count of unique elements
        return set.size();
    } // O(nlogn) & O(n)
    // insertion into TreeSet is logn

    // Optimal Approach (two-pointer method)
    public static int removeDuplicates_opt(int[] arr, int n) {
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return i + 1; // size of unique elements
    } // O(n) & O(1)

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 4, 8, 8};
        int n1 = arr1.length;

        // Brute Force
        int newSizeBru = removeDuplicates_bru(arr1.clone(), n1);
        System.out.print("Brute Force new array: ");
        for (int i = 0; i < newSizeBru; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("\nSize: " + newSizeBru);

        // Optimal
        int[] arr2 = {2, 4, 4, 8, 8};
        int n2 = arr2.length;
        int newSizeOpt = removeDuplicates_opt(arr2, n2);
        System.out.print("Optimal new array: ");
        for (int i = 0; i < newSizeOpt; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println("\nSize: " + newSizeOpt);
    }
}
