package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> paren = new ArrayList<>();
        
        generateParenUtil(n, "", paren);
        return paren;
    }
    
    private boolean validParen(String paren) {
        if (paren.length() == 0) {
            return false;
        }
        Stack st = new Stack();
        for (int i = 0; i < paren.length(); ++i) {
            if (paren.charAt(i) == '(') {
                st.push('(');
            } else {
                if (st.empty()) {
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
    
    private void generateParenUtil(int n, String sb, List<String> result) {
        if (sb.length() == n) {
            if (validParen(sb)) {
                result.add(sb);
            }
            return;
        }
        generateParenUtil(n, sb + '(', result);
        generateParenUtil(n, sb + ')', result);
    }
    
    public static void main(String[] args) {
         GenerateParentheses g = new GenerateParentheses();
         List<String> paren = g.generateParenthesis(8);
         System.out.println(paren);
    }
}
