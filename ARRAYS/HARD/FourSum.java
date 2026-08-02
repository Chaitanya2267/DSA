import java.util.*;

public class FourSum {
    public List<List<Integer>> brute(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> better(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> seen = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long req = (long) target - arr[i] - arr[j] - arr[k];
                    if (seen.contains((int) req)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) req);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public List<List<Integer>> opt(int[] arr, int target) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        while (left < right && arr[left] == arr[left + 1])
                            left++;
                        while (left < right && arr[right] == arr[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FourSum obj = new FourSum();

        int[] arr = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        // Brute Force
        System.out.println("\nBrute Force Result:");
        System.out.println(obj.brute(Arrays.copyOf(arr, arr.length), target));

        // Better Approach
        System.out.println("\nBetter Approach Result:");
        System.out.println(obj.better(Arrays.copyOf(arr, arr.length), target));

        // Optimal Approach
        System.out.println("\nOptimal Approach Result:");
        System.out.println(obj.opt(Arrays.copyOf(arr, arr.length), target));
    }
}
