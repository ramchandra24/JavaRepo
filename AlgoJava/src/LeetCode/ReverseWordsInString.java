package LeetCode;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        String result = "";
        String inter = "";
        for (int i = 0; i < s.length(); ++i) {
            inter = s.charAt(i) + inter;
            if (s.charAt(i) == ' ') {
                result = result + inter;
                inter = "";
            }
        }
        result = result + ' ' + inter;
        return result.substring(1);
    }
    public static void main(String[] args) {
        ReverseWordsInString rw = new ReverseWordsInString();
        System.out.println(rw.reverseWords("let's go to the mall"));
    }
}
