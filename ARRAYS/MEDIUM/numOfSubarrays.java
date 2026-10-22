// 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0; int cnt = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if(sum / k >= threshold) { cnt++; }
        for(int i = k; i < arr.length; i++) {
            sum = sum - arr[i - k] + arr[i];
            if(sum / k >= threshold) { cnt++; }
        }
        return cnt;
    }
}
