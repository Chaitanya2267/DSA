// 1922. Count Good Numbers

class Solution {
    private static final long MOD = 1000000007L;
    private static long power(long x, long n) {
        if(n == 0) { return 1; }
        long half = power(x, n/2);
        long result = (half * half) % MOD;
        if(n%2 == 1) { result = (result * x)%MOD; }
        return result;
    }
    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        long totalCombinations = (power(5, evenCount)) * (power(4, oddCount)) % MOD;
        return (int)totalCombinations; 
    }
}
