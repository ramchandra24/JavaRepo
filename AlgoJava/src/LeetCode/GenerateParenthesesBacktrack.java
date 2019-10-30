package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesesBacktrack {

    public List<String> generateParenthesis(int n) {
        List<String> paren = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder(2 * n);

        generateParenUtil(2 * n, 0, sb, paren);
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

    private void generateParenUtil(int n, int start, StringBuilder sb, List<String> result) {
        //System.out.println(sb.toString());
        if (sb.length() == n) {
            if (validParen(sb.toString())) {
                result.add(sb.toString());
            }
            return;
        }
        for (int i = start; i < n; ++i) {
            generateParenUtil(n, i + 1, sb.append('('), result);
            sb.deleteCharAt(sb.length() - 1);
            generateParenUtil(n, i + 1, sb.append(')'), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }

    public static void main(String[] args) {
        GenerateParenthesesBacktrack g = new GenerateParenthesesBacktrack();
        List<String> paren = g.generateParenthesis(8);
        
        System.out.println("output");
        System.out.println(paren);
    }

}
