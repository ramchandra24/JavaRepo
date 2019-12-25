package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

class CharCounter {
    char ch;
    int count;

    CharCounter(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class CharCounterComparator implements Comparator<CharCounter> {
    @Override
    public int compare(CharCounter a, CharCounter b) {
        // TODO Auto-generated method stub
        return b.count - a.count;
    }
}

public class SortCharsByFreq {

    private int getIndexForChar(char ch) {
        if (ch >= 'a' && ch <= 'z')
            return ch - 'a';
        return ch - 'A' + 26;
    }

    public String frequencySort(String s) {
        CharCounter[] count = new CharCounter[52];
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            int index = getIndexForChar(ch);
            count[index] = new CharCounter(ch, 0);
        }
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            int index = getIndexForChar(ch);
            count[index] = new CharCounter(ch, 0);
        }
        for (int i = 0; i < s.length(); ++i) {
            int index = getIndexForChar(s.charAt(i));
            count[index].count++;
        }
        Arrays.sort(count, new CharCounterComparator());
        String result = "";
        for (int i = 0; i < count.length; ++i) {
            int charCount = count[i].count;
            while (charCount > 0) {
                result += count[i].ch;
                charCount--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortCharsByFreq obj = new SortCharsByFreq();
        String res = obj.frequencySort("tree");
        System.out.println(res);
    }
}
