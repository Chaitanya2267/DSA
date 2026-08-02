import java.util.*;

public class PascalTriangle {
    // 1. Given Row and Col tell the element at that place.
    public long r_c(int r, int c) {
        int n = r - 1;
        int k = c - 1;
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    // 2. Print an Nth row of Pascal triangle.
    public static long nCr(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        if (r == 0 || r == n)
            return 1;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public List<Long> getNthRow(int N) {
        List<Long> row = new ArrayList<>();
        long val = 1;
        row.add(val);
        for (int k = 1; k < N; k++) {
            val = val * (N - k) / k;
            row.add(val);
        }
        return row;
    }

    // 3. Given N, print the entire triangle.
    public static int pascal(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static List<List<Integer>> brute(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            List<Integer> temp = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                temp.add(pascal(row - 1, col - 1));
            }
            ans.add(temp);
        }
        return ans;
    }

    public List<List<Integer>> opt(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            for (int j = 1; j < i; j++) {
                row.set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();

        // 1. Find element at a given row and column
        int row = 5, col = 3;
        System.out.println("Element at Row " + row + ", Column " + col + " = "
                + pt.r_c(row, col));

        // 2. Print the Nth row
        int N = 5;
        System.out.println("\n" + N + "th Row:");
        List<Long> nthRow = pt.getNthRow(N);
        System.out.println(nthRow);

        // 3. Print Pascal Triangle using brute method
        int rows = 5;
        System.out.println("\nPascal Triangle (Brute):");
        List<List<Integer>> bruteTriangle = brute(rows);
        for (List<Integer> r : bruteTriangle) {
            System.out.println(r);
        }

        // 4. Print Pascal Triangle using optimized method
        System.out.println("\nPascal Triangle (Optimized):");
        List<List<Integer>> optTriangle = pt.opt(rows);
        for (List<Integer> r : optTriangle) {
            System.out.println(r);
        }
    }
}