// check if the array is sorted

public class SA {
    // Iterative approach
    public boolean isSortedIterative(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) { // violation of ascending order
                return false;
            }
        }
        return true;
    }

    // Recursive helper
    public static boolean isSortedHelper(int[] arr, int n) {
        if (n == 1 || n == 0) {
            return true; // base case
        }
        return arr[n - 1] >= arr[n - 2] && isSortedHelper(arr, n - 1);
    }

    // Recursive wrapper
    public static boolean isSortedRecursive(int[] arr) {
        return isSortedHelper(arr, arr.length);
    }

    public static void main(String[] args) {
        SA obj = new SA();
        int[] arr1 = {2, 4, 4, 5, 9};
        int[] arr2 = {10, 30, 40, 20, 50};

        // Iterative check
        System.out.println("Iterative check arr1: " + obj.isSortedIterative(arr1, arr1.length));
        System.out.println("Iterative check arr2: " + obj.isSortedIterative(arr2, arr2.length));

        // Recursive check
        System.out.println("Recursive check arr1: " + isSortedRecursive(arr1));
        System.out.println("Recursive check arr2: " + isSortedRecursive(arr2));
    }
}
