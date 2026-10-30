// Generate Binary Strings Without Consecutive 1s

class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, "", ans);
        return ans;
    }
    private void generate(int n, String curr, List<String> ans) {
        if(curr.length() == n) {
            ans.add(curr);
            return;
        }
        generate(n, curr + "0", ans);
        if(curr.length() == 0 || curr.charAt(curr.length() - 1) != '1') {
            generate(n, curr + '1', ans);
        }
    }
}
