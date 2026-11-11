// 435. Non-overlapping Intervals

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) { return 0; }
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[1], second[1]));
        int removeCount = 0; int lastEndTime = intervals[0][1];
        for(int i = 1; i < intervals.length ; i++) {
            if(intervals[i][0] < lastEndTime) { removeCount++; }
            else { lastEndTime = intervals[i][1]; }
        }
        return removeCount;
    }
}
