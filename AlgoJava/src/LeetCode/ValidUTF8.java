package LeetCode;

import java.util.Arrays;
import java.util.List;

public class ValidUTF8 {
    public static boolean validUtf8(int[] data) {

        int i = 0;
        while (i < data.length) {
            if ((data[i] & 0x80) == 0x0) {
                ++i;
            } else if ((data[i] & 0xE0) == 0xC0 && true == validUtf8Util(Arrays.copyOfRange(data, i, i + 2))) {
                i += 2;
            } else if ((data[i] & 0xF0) == 0xE0 && true == validUtf8Util(Arrays.copyOfRange(data, i, i + 3))) {
                i += 3;
            } else if ((data[i] & 0xF8) == 0xF0 && true == validUtf8Util(Arrays.copyOfRange(data, i, i + 4))) {
                i += 4;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean validUtf8Util(int[] data) {
        int len = data.length;
        switch (len) {
        case 1:
            return (data[0] & 0x80) == 0x0;
        case 2:
            return ((data[0] & 0xE0) == 0xC0 && (data[1] & 0xC0) == 0x80);
        case 3:
            return ((data[0] & 0xF0) == 0xE0 && (data[1] & 0xC0) == 0x80 && (data[2] & 0xC0) == 0x80);
        case 4:
            return ((data[0] & 0xF8) == 0xF0 && (data[1] & 0xC0) == 0x80 && (data[2] & 0xC0) == 0x80
                    && (data[3] & 0xC0) == 0x80);
        default:
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(ValidUTF8.validUtf8(new int[] {197, 130, 1}));
    }

}
