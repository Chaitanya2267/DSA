import java.util.*;

public class NextPermutation {
    public List<Integer> brute(int[] arr) {

        List<List<Integer>> all = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        for (int num : arr)
            current.add(num);

        Arrays.sort(arr);

        permute(arr, 0, all);

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(current)) {
                if (i == all.size() - 1)
                    return all.get(0);
                return all.get(i + 1);
            }
        }
        return current;
    }

    private void permute(int[] arr, int start, List<List<Integer>> all) {
        if (start == arr.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : arr)
                temp.add(num);
            all.add(temp);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, i, start);
            permute(arr, start + 1, all);
            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void opt(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1, nums.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();

        int[] arr1 = { 1, 2, 3 };
        System.out.println(sol.brute(arr1));

        int[] arr2 = { 1, 2, 3 };
        sol.opt(arr2);

        System.out.println(Arrays.toString(arr2));
    }
}
