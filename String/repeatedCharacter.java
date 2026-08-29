class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (seen[index]) {
                return s.charAt(i);
            }

            seen[index] = true;
        }

        return '\0'; // No repeated character
    }
}
// -------------------------------------------------------------

class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();

        for(char ch : s.toCharArray()) {
            if(set.contains(ch)) {
                return ch;
            }
            set.add(ch);
        }
        return ' ';
    }
}
