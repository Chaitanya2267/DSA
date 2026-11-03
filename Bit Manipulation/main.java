public class Solution{
    public String convert2binary(int n) {
        if(n == 0) { return "0"; }
        String res = "";
        while(n != 0) {
            if(n % 2 == 1) res += '1';
            else res += '0';
            n = n / 2;
        }
        return reverse(res);
    }
    public String reverse(String str) {
        String rev = "";
        for(int i = str.length()-1; i >= 0; i--) { rev += str.charAt(i); }
        return rev;
    }

    public int convert2Decimal(String x) {
        int len = x.length(); int p2 = 1; int num = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(x.charAt(i) == '1') num += p2;
            p2 *= 2;
        }
        return num;
    }
}
