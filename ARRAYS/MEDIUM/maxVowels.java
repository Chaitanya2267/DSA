// 1456. Maximum Number of Vowels in a Substring of Given Length

class Solution {
    boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
    public int maxVowels(String s, int k) {
        int vowel = 0; int max = 0;
        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) vowel++;
        }
        max = vowel;
        for(int i = k; i < s.length(); i++) {
            if(isVowel(s.charAt(i - k))) vowel--;
            if(isVowel(s.charAt(i))) vowel++;
            max = Math.max(max, vowel);
        }
        return max;
    }
}
