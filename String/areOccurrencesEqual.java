// 1941. Check if All Characters Have Equal Number of Occurrences

class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c -'a']++;
        }
        int x = 0;
        for(int i : count) {
            if(i != 0 && x == 0) {
                x = i;
            } else if(i != 0){
                if(x != i) { return false; }
            }
        }
        return true;
    }
}
// ---------------------------------------------------------------

class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int freq = map.values().iterator().next();

        for(int count : map.values()) {
            if(count != freq){ return false; }
        }

        return true;
    }
}
