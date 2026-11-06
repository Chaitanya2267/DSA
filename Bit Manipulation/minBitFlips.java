// 2220. Minimum Bit Flips to Convert Number

class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = 0; int cnt = 0;
        ans = start ^ goal; 
        for(int i = 0; i < 31; i++) {
            if((ans & (1 << i)) != 0) cnt++;
        }
        return cnt;
    }
}
