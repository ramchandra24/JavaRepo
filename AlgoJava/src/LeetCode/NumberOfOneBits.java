package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOneBits {

    public static List<Integer> getOneCount(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int index = 1;
        while (n != 0) {
            int isOne = n & 1;
            if (isOne == 1) {
                res.add(0, index);
            }
            ++index;
            n >>>= 1;
        }
        res.add(0, res.size());

        int sub = res.get(1);
        for (int i = 1; i < res.size(); ++i) {
            res.set(i, sub - res.get(i) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> out = NumberOfOneBits.getOneCount(1626564);
        for (int n : out) {
            System.out.println(n);
        }
    }
}
