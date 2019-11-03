package LeetCode;

import java.util.Stack;

public class ValidAllParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.empty()) {
                    return false;
                }
                
                if ((ch != ')' && st.peek() == '(') || (ch != '}' && st.peek() == '{') || (ch != ']' && st.peek() == '[')) {
                    return false;
                }
                st.pop();
            }
        }
        if (st.empty()) {
            return true;
        }
        return false;
    }
}
