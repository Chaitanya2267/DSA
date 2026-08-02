import java.util.*;

public class Leaders {
    // Brute force approach
    public ArrayList<Integer> leaders_brute(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean leader = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    // Optimized approach
    public ArrayList<Integer> leaders_opt(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr.length == 0) {
            return ans;
        }
        int max = arr[arr.length - 1];
        ans.add(max);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                ans.add(arr[i]);
                max = arr[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 1, 2 };
        Leaders finder = new Leaders();

        // Option 1: Brute force
        ArrayList<Integer> ansBrute = finder.leaders_brute(arr);
        System.out.println("Leaders (Brute): " + ansBrute);

        // Option 2: Optimized
        ArrayList<Integer> ansOpt = finder.leaders_opt(arr);
        System.out.println("Leaders (Optimized): " + ansOpt);
    }
}
