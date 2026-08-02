// left rotate the array by one place

public class LRA {
    public static void rotateArray(int[] arr, int n) {
        int temp = arr[0]; // store first element
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i]; // shift elements left
        }
        arr[n - 1] = temp; // put first element at the end
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        int n = arr.length;

        rotateArray(arr, n);

        System.out.print("Array after left rotation: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
