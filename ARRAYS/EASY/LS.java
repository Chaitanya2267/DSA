public class LS {

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i; // Element found
            }

        }

        return -1; // Element not found
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        int target = 3;

        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}