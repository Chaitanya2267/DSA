// 216. Combination Sum III

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private void findCombinations(int start, int k, int n, List<Integer> curr, List<List<Integer>> ans) {
        if(curr.size() == k) {
            if(n == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        for(int i = start; i <= 9; i++) {
            curr.add(i);
            findCombinations(i + 1, k, n - i, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}
