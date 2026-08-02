public class Sort012 {
    public static void bruteSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    public static void betterSort(int[] arr) {
        int n = arr.length;
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // for (int i = 0; i < n; i++) {
        //     if (arr[i] == 0) { cnt0++; }
        //     else if (arr[i] == 1) { cnt1++; } 
        //     else { cnt2++; }
        // }

        for (int i = 0; i < n; i++) {
            switch (arr[i]) {
                case 0 -> cnt0++;
                case 1 -> cnt1++;
                default -> cnt2++;
            }
        }

        for (int i = 0; i < cnt0 ; i++) { arr[i] = 0 ; }
        for (int i = cnt0 ; i < cnt0 + cnt1 ; i++) { arr[i] = 1 ; }
        for (int i = cnt0 + cnt1  ; i < n ; i++) { arr[i] = 2 ; }
    }

    public static void optSort(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1 ;
        while(mid <= high) {
            // if(arr[mid] == 0){
            //     int temp = arr[low];
            //     arr[low] = arr[mid];
            //     arr[mid] = temp;
            //     low++;
            //     mid++;
            // }
            // else if(arr[mid] == 1) {
            //     mid++;
            // }
            // else { 
            //     int temp = arr[mid];
            //     arr[mid] = arr[high];
            //     arr[high] = temp;
            //     high--;
            // }
            switch (arr[mid]) {
                case 0 -> {
                        int temp = arr[low];
                        arr[low] = arr[mid];
                        arr[mid] = temp;
                        low++;
                        mid++;
                    }
                case 1 -> mid++;
                default -> {
                        int temp = arr[mid];
                        arr[mid] = arr[high];
                        arr[high] = temp;
                        high--;
                    }
            }
            // switch (arr[mid]) {
            //     case 0:
            //         {
            //             int temp = arr[low];
            //             arr[low] = arr[mid];
            //             arr[mid] = temp;
            //             low++;
            //             mid++;
            //             break;
            //         }
            //     case 1:
            //         mid++;
            //         break;
            //     default:
            //         {
            //             int temp = arr[mid];
            //             arr[mid] = arr[high];
            //             arr[high] = temp;
            //             high--;
            //             break;
            //         }
            // }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 0, 2, 0, 0, 1, 2, 0 };
        bruteSort(arr);
        betterSort(arr);
        optSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
