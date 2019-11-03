package LeetCode;

public class ReverseWordsInString2 {
    public String reverseWords(String s) {
        String result = "";
        String inter = "";
        if (s.length() < 1) {
            return s;
        }
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (inter.compareTo("") != 0) {
                    result = inter + ' ' + result;
                }
                inter = "";
            } else {
                inter += ch;
            }
        }
        if (inter.compareTo("") != 0) {
            result = inter + ' ' + result;
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseWordsInString2 r = new ReverseWordsInString2();
        System.out.println(r.reverseWords("   "));
    }
}
