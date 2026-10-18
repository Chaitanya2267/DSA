// opt approach
/*
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1 ; i < n ; i++ ) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k - 1;
        while(true) {
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0) { break; }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
}
*/

// updated opt approach
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i < n; i++) { fact *= i; }
        for(int i = 1; i <= n; i++) { numbers.add(i); }
        k--;    // convert to 0-based indexing
        StringBuilder ans = new StringBuilder();
        while(true) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);
            if(numbers.size() == 0) { break; }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }
}
