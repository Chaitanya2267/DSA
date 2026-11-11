// 57. Insert Interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        list.add(newInterval);
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] current = list.get(i);
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {
                merged.add(current);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], current[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
