import java.util.ArrayList;
import java.util.Scanner;

class SortingAlgo {

    public static void bubble_sort(int[] arr, int n) {

        // Traverse the array from end to beginning
        for (int i = n - 1; i >= 0; i--) {

            // Flag to check if any swap happens
            int didSwap = 0;

            // Compare adjacent elements
            for (int j = 0; j <= i - 1; j++) {

                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;

                    didSwap = 1;
                }
            }

            // If no swaps happened, array is already sorted
            if (didSwap == 0) {
                break;
            }
        }
    }

    public static void insertion_sort(int[] arr, int n) {

        // Iterate through each element
        for (int i = 0; i <= n - 1; i++) {

            int j = i;

            // Move current element to correct position
            while (j > 0 && arr[j - 1] > arr[j]) {

                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;

                j--;
            }

            // Debug output for each iteration
            System.out.println("insertion");
        }
    }

    public static void selection_sort(int[] arr, int n) {

        // Iterate through array
        for (int i = 0; i <= n - 2; i++) {

            // Assume current index is minimum
            int mini = i;

            // Find index of smallest element in remaining array
            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }

            // Swap smallest element with current position
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;

            // Debug output for each pass
            System.out.println("selection");
        }
    }

    public static void merge_sort(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // merge two sorted halves
        // compare elements from both halves and add the smaller one to temp
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        // remaining left part
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        // remaining right part
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        // copy back to the original
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void mergeSortHelper(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSortHelper(arr, low, mid); // sort left half
        mergeSortHelper(arr, mid + 1, high); // sort right half

        merge_sort(arr, low, mid, high); // merge sorted halves
    }

    public static void merge_Sort(int[] arr, int n) {
        mergeSortHelper(arr, 0, n - 1);
    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            // find first element greater than pivot from the left
            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }
            // find first element smaller than or equal to pivot from the right
            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }
            // swap if i and j haven't crossed
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // place pivot in correct position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pIndex - 1);
            quickSortHelper(arr, pIndex + 1, high);
        }
    }

    public static void quick_sort(int[] arr, int n) {
        quickSortHelper(arr, 0, n - 1);
    }

    public static void main(String args[]) {

        try (Scanner sc = new Scanner(System.in)) {

            // Read number of elements
            int n = sc.nextInt();

            int[] arr = new int[n];

            // Read array elements
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Apply sorting algorithms sequentially
            // bubble_sort(arr, n);
            // insertion_sort(arr, n);
            // selection_sort(arr, n);
            // merge_Sort(arr, n);
            quick_sort(arr, n);

            // Print final sorted array
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i] + " ");
            }
        }
    }
}