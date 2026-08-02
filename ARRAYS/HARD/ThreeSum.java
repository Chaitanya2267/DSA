import java.util.*;

public class ThreeSum {
    public List<List<Integer>> brute(int[] arr, int n) {
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(st);
    }

    public List<List<Integer>> better(int[] arr, int n) {
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                hashSet.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }

    public List<List<Integer>> opt(int[] arr, int n) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1])
                        left++;
                    while (left < right && arr[right] == arr[right + 1])
                        right++;
                } else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();

        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;

        System.out.println("Input Array: " + Arrays.toString(arr));

        // Brute Force
        System.out.println("\nBrute Force Result:");
        List<List<Integer>> bruteAns = obj.brute(arr, n);
        System.out.println(bruteAns);

        // Better Approach
        System.out.println("\nBetter Approach Result:");
        List<List<Integer>> betterAns = obj.better(arr, n);
        System.out.println(betterAns);

        // Optimal Approach
        // Pass a copy because opt() sorts the array
        System.out.println("\nOptimal Approach Result:");
        List<List<Integer>> optAns = obj.opt(Arrays.copyOf(arr, n), n);
        System.out.println(optAns);
    }
}
