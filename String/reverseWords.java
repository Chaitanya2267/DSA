class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){word.append(s.charAt(i)); }
            else if(word.length() > 0) {
                words.add(word.toString());
                word.setLength(0);
            }
        }
        if(word.length() > 0) {words.add(word.toString()); }
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
