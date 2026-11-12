// 2406. Divide Intervals Into Minimum Number of Groups

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0; int j = 0;
        int cnt = 0; int maxcnt = 0;
        while(i < n && j < n) {
            if(start[i] <= end[j]) {
                cnt++; 
                maxcnt = Math.max(maxcnt, cnt);
                i++;
            } else {
                cnt--;
                j++;
            }
        }
        return maxcnt;
    }
}
