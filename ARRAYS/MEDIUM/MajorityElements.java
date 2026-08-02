import java.util.*;
import java.util.Map.Entry;

public class MajorityElements {
    public static int brute(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i]) {
                    cnt++;
                }
            }
            if (cnt > n / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int better(List<Integer> arr) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            mpp.put(arr.get(i), mpp.getOrDefault(arr.get(i), 0) + 1);
        }
        for (Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (arr.size() / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    public static int opt(List<Integer> arr) {
        int cnt = 0, el = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = arr.get(i);
            } else if (arr.get(i) == el) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == el) {
                cnt1++;
            }
        }
        if (cnt1 > (arr.size() / 2)) {
            return el;
        }
        return -1;
    }

    public static void main(String[] args) {
        // int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        // System.out.println(brute(arr));
        List<Integer> list = Arrays.asList(2, 2, 1, 1, 1, 2, 2);
        // System.out.println(better(list));
        System.out.println(opt(list));
    }
}
