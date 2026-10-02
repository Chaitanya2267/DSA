// 1394. Find Lucky Integer in an Array

class Solution {
    public int findLucky(int[] arr) {
        int maxLucky = -1;
        for(int i = 0 ; i < arr.length; i++){
            int cnt = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){cnt++;}
            }
            if(arr[i] == cnt){maxLucky = Math.max(maxLucky, arr[i]);}
        }
        return maxLucky; 
    }
}
// --------------------------------------------------------------------------

class Solution {
    public int findLucky(int[] arr) {
        int cnt[] = new int[501];
        for(int x : arr){
            cnt[x]++;
        }
        for(int i = 500; i >= 1; i--){
            if(i == cnt[i]){
                return i;
            }
        }
        return -1;
    }
}
// --------------------------------------------------------------------------
