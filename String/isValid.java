class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){stack.push(s.charAt(i));}
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '(') {stack.pop();}
                else return false;
            }
            if(s.charAt(i) == '['){stack.push(s.charAt(i));}
            if(s.charAt(i) == ']'){
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '[') {stack.pop();}
                else return false;
            }

            if(s.charAt(i) == '{'){stack.push(s.charAt(i));}
            if(s.charAt(i) == '}'){
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '{') {stack.pop();}
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
// -----------------------------------------------------------------------------------------

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);  // CHANGE 1

            if(ch == '(') {stack.push(ch);}
            if(ch == ')') {
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '(') {stack.pop();}
                else {return false;}
            }

            if(ch == '[') {stack.push(ch);}
            if(ch == ']') {
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '[') {stack.pop();}
                else {return false;}
            }

            if(ch == '{') {stack.push(ch);}
            if(ch == '}') {
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '{') {stack.pop();}
                else {return false;}
            }
        }
        return stack.isEmpty();  
    }
}
// -----------------------------------------------------------------------------------------

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){stack.push(ch);}
            else if(ch == ')'){
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '(') {stack.pop();}
                else{return false;}
            }
            else if(ch == '['){stack.push(ch);}
            else if(ch == ']'){
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '[') {stack.pop();}
                else{return false;}
            }
            else if(ch == '{'){stack.push(ch);}
            else if(ch == '}'){
                if(stack.isEmpty()) {return false;}
                if(stack.peek() == '{') {stack.pop();}
                else{return false;}
            }
        }
        return stack.isEmpty();
    }
}
