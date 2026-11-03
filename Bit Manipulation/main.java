public class Solution{
    // 1.
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

    // 2.
    public int convert2Decimal(String x) {
        int len = x.length(); int p2 = 1; int num = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(x.charAt(i) == '1') num += p2;
            p2 *= 2;
        }
        return num;
    }

    // 3.
    public void swap2Numbers(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    // 4.
    public boolean isIthBitSet(int num, int i) {
        return (num & (1 << i )) != 0; 
    }

    // 5.
    public int setIthBit(int num, int i) {
        return num | (1 << i );
    }

    // 6.
    public int clearIthBit(int num, int i) {
        return num & ~(1 << i );
    }

    // 7.
    public int toggleIthBit(int num, int i) {
        return num ^ (1 << i);
    }

    // 8.
    public int removeLastSetBit(int num) {
        return num & (num - 1);
    }

    // 9.
    public boolean isOdd(int num) {
        return (num & 1) != 0;
    }

    // 9.
    public int countSetBits(int num) {
    int cnt = 0;

    while(num > 0) {
        num = num & (num - 1);
        cnt++;
    }

    return cnt;
}
}
