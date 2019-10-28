package LeetCode;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        }
        int maxLength = 1;
        int start = 0;
        boolean[][] isPal = new boolean[s.length()][s.length()];
        // 1 char palindrome
        for (int i = 0; i < s.length(); ++i) {
            isPal[i][i] = true;
        }
        // 2 char palindrome
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                isPal[i-1][i] = true;
                start = i - 1;
                maxLength = 2;
            }
        }
        for (int k = 3; k <= s.length(); ++k) {
            for (int i = 0; i < s.length() - k + 1; ++i) {
                int j = i + k - 1;
                System.out.println(s.substring(i, j + 1) + " i : " + i + " :: j : " + j);
                if (isPal[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    isPal[i][j] = true;
                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }
                printMat(isPal);
            }
        }

        return s.substring(start, start + maxLength);
    }

    static void printMat(boolean[][] mat) {
        System.out.println("Mat : ");
        for (boolean[] row : mat) {
            for (boolean elem : row) {
                System.out.print((elem == true ? 1 : 0) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
