// 39. Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    private void findCombinations(
            int i,
            int[] arr,
            int target,
            List<Integer> ds,
            List<List<Integer>> ans) {
        if (i == arr.length) {
            if (target == 0) { ans.add(new ArrayList<>(ds)); }
            return;
        }
        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombinations(i, arr, target - arr[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
        findCombinations(i + 1, arr, target, ds, ans);
    }
}
