// move all zeros to the end of the array

import java.util.ArrayList;

public class MZE {

    public static void moveZerosToEnd_bru(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> temp = new ArrayList<>();

        // Store all non-zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        // Copy non-zero elements back
        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        // Fill remaining positions with 0
        for (int i = temp.size(); i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void moveZerosToEnd_opt(int[] arr) {
    int n = arr.length;

    int j = -1;

    // Find the first zero
    for (int i = 0; i < n; i++) {
        if (arr[i] == 0) {
            j = i;
            break;
        }
    }

    // No zero found
    if (j == -1) {
        return;
    }

    // Move non-zero elements forward
    for (int i = j + 1; i < n; i++) {
        if (arr[i] != 0) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            j++;
        }
    }
}

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 0, 3, 0, 4 };

        moveZerosToEnd_bru(arr);

        // moveZerosToEnd_opt(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

