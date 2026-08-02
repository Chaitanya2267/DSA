import java.util.*;

public class MergeOverlappingSubIntervals {

    // Brute Force Approach
    public List<List<Integer>> brute(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;
            while (j < n && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            ans.add(new ArrayList<>(Arrays.asList(start, end)));
            i = j;
        }

        return ans;
    }

    // Optimal Approach
    public List<List<Integer>> opt(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> merged = new ArrayList<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() ||
                    merged.get(merged.size() - 1).get(1) < interval[0]) {

                merged.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
            } else {

                List<Integer> last = merged.get(merged.size() - 1);
                last.set(1, Math.max(last.get(1), interval[1]));
            }
        }

        return merged;
    }

    // Utility function to print result
    public static void print(List<List<Integer>> intervals) {
        for (List<Integer> interval : intervals) {
            System.out.print("[" + interval.get(0) + ", " + interval.get(1) + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MergeOverlappingSubIntervals obj = new MergeOverlappingSubIntervals();

        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 },
                { 17, 20 }
        };

        System.out.println("Brute Force:");
        List<List<Integer>> bruteAns = obj.brute(intervals);
        print(bruteAns);

        // Need a fresh array because sorting modifies the original array
        int[][] intervals2 = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 },
                { 17, 20 }
        };

        System.out.println("Optimal:");
        List<List<Integer>> optAns = obj.opt(intervals2);
        print(optAns);
    }
}