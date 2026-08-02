import java.util.*;

public class MajorityElements {
    public List<Integer> brute(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (result.isEmpty() || result.get(0) != arr[i] && (result.size() < 2 || result.get(1) != arr[i])) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }
                if (count > n / 3) {
                    result.add(arr[i]);
                }
            }
            if (result.size() == 2) {
                break;
            }
        }
        return result;
    }

    public List<Integer> better(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        int mini = n / 3 + 1;
        for (int i = 0; i < n; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
            if (mpp.get(arr[i]) == mini) {
                result.add(arr[i]);
            }
            if (result.size() == 2)
                break;
        }
        return result;
    }

    public List<Integer> opt(int[] arr) {
        int n = arr.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != arr[i]) {
                cnt1 = 1;
                el1 = arr[i];
            } else if (cnt2 == 0 && el1 != arr[i]) {
                cnt2 = 1;
                el2 = arr[i];
            } else if (arr[i] == el1) {
                cnt1++;
            } else if (arr[i] == el2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el1)
                cnt1++;
            if (arr[i] == el2)
                cnt2++;
        }
        int mini = n / 3 + 1;
        List<Integer> result = new ArrayList<>();
        if (cnt1 >= mini)
            result.add(el1);
        if (cnt2 >= mini && el1 != el2)
            result.add(el2);

        return result;
    }

    public static void main(String[] args) {
        MajorityElements obj = new MajorityElements();

        // Test for Brute Force
        int[] arr1 = { 3, 2, 3 };
        System.out.println("Brute Force");
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Result: " + obj.brute(arr1));

        // Test for Better
        int[] arr2 = { 1, 1, 1, 3, 3, 2, 2, 2 };
        System.out.println("\nBetter");
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Result: " + obj.better(arr2));

        // Test for Optimal
        int[] arr3 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("\nOptimal");
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Result: " + obj.opt(arr3));
    }
}

/*
| Method     | Time  | Space |
| ---------- | ----- | ----- |
| `brute()`  | O(n²) | O(1)  |
| `better()` | O(n)  | O(n)  |
| `opt()`    | O(n)  | O(1)  |
*/
