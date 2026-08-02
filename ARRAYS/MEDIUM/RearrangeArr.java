import java.util.*;

public class RearrangeArr {
    public static int[] brute(int[] arr) {
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();

        for (int num : arr) {
            if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }
        for (int i = 0; i < positives.size(); i++) {
            arr[2 * i] = positives.get(i);
            arr[2 * i + 1] = negatives.get(i);
        }
        return arr;
    }

    public static int[] opt(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                ans[negIndex] = arr[i];
                negIndex += 2;
            } else {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    public static int[] more(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }
        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 3, -1, -2, -5, 2, 4 };
        System.out.println(Arrays.toString(brute(arr)));
        System.out.println(Arrays.toString(opt(arr)));

        int[] abc = {1, 2, 3, -1} ;
        System.out.println(Arrays.toString(more(abc)));
    }
}
