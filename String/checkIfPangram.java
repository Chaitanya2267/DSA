// 1832. Check if the Sentence Is Pangram

class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        for(char c : sentence.toCharArray()) {
            seen[c - 'a'] = true;
        }
        for(boolean b : seen){
            if(!b) return false;
        }
        return true;
    }
}
