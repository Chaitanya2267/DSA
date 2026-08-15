class Solution {
    public int mySqrt(int x) {
        if(x <  2) return x;
        int l = 1, r = x/2, ans = 0;
        while(l <= r){
            long m = l + (r - l)/2;
            if(m*m <= x){
                ans = (int)m; l = (int)m + 1;
            } else { r = (int)m - 1; } 
        }
        return ans;
    }
}
