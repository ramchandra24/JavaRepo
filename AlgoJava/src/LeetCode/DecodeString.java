package LeetCode;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Character> st = new Stack();
        Stack<Integer> times = new Stack();
        String num = new String();

        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num += s.charAt(i);
            } else if (Character.isAlphabetic(s.charAt(i))) {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                times.push(Integer.parseInt(num));
                num = "";
                st.push('[');
            } else if (s.charAt(i) == ']') {
                String curr = new String();
                while (!st.empty()) {
                    Character ch = st.pop();
                    if (ch == '[') {
                        // repeat curr, push back into stack

                        int t = times.pop();
                        String temp = new String(curr);
                        System.out.println("times: " + t + " " + curr);
                        for (int j = 1; j < t; ++j) {
                            temp += curr;
                        }
                        for (int j = 0; j < temp.length(); ++j) {
                            st.push(temp.charAt(j));
                        }
                        break;
                    }
                    curr = ch + curr;
                }
            }
        }
        String res = new String();
        while (!st.empty()) {
            res = st.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String res = DecodeString.decodeString("2[a2[c]]6[b]");
        System.out.println(res);
    }
}
