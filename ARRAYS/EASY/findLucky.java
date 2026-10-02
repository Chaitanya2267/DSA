// 1394. Find Lucky Integer in an Array

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
