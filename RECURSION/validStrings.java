// 3211. Generate Binary Strings Without Adjacent Zeros

class Solution {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, "", ans);
        return ans;
    }
    private void generate(int n, String curr, List<String> ans) {
        if(curr.length() == n) {
            ans.add(curr);
            return;
        }
        generate(n, curr + "1", ans);
        if(curr.length() == 0 || curr.charAt(curr.length() - 1) != '0') {
            generate(n, curr + '0', ans);
        }
    }
}
