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
// -----------------------------------------------------------------------------------------

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '('){return false;}
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '['){return false;}
                    stack.pop();
                    break;
                case '}': 
                    if(stack.isEmpty() || stack.peek() != '{'){return false;}
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }
}
// -----------------------------------------------------------------------------------------

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            } else {
                if(stack.isEmpty()){return false;}
                if(stack.peek() != map.get(ch)){return false;}
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
