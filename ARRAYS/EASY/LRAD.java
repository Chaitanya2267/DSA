// left rotate the array by D places

public class LRAD {

    // Brute Force Approach (using temp array)
    @SuppressWarnings("ManualArrayToCollectionCopy")
    public static void rotateArray_bru(int[] arr, int n, int d) {
        // Step 1: Copy first d elements into temp
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        // Step 2: Shift remaining elements left
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }

        // Step 3: Copy temp elements back to the end
        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
    }

    // Helper function for reversal
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Optimal Approach (Reversal Algorithm)
    public static void leftRotate_opt(int[] arr, int n, int d) {
        if (n == 0)
            return;
        d = d % n; // handle cases where d > n

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse remaining elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
    }

    

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        int n1 = arr1.length;
        int d = 4;

        // Brute Force Rotation
        rotateArray_bru(arr1, n1, d);
        System.out.print("Brute Force Rotation: ");
        for (int i = 0; i < n1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        // Reset array for optimal rotation
        int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
        int n2 = arr2.length;

        // Optimal Rotation
        leftRotate_opt(arr2, n2, d);
        System.out.print("Optimal Rotation: ");
        for (int i = 0; i < n2; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
