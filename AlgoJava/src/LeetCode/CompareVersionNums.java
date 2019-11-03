package LeetCode;

public class CompareVersionNums {
    public int compareVersion(String version1, String version2) {
        int v1Len = version1.length();
        int v2Len = version2.length();

        String[] ver1 = version1.split("[.]+");
        String[] ver2 = version2.split("[.]+");

        for (String s : ver1) {
            System.out.print(s);
        }
        System.out.println();
        for (String s : ver2) {
            System.out.print(s);
        }
        int i = 0;
        int iVer1 = 0, iVer2 = 0;
        while (i < ver1.length || i < ver2.length) {
            if (i < ver1.length) {
                iVer1 = iVer1 * 10 + Integer.parseInt(ver1[i]);
            } else {
                iVer1 = iVer1 * 10;
            }
            if (i < ver2.length) {
                iVer2 = iVer2 * 10 + Integer.parseInt(ver2[i]);
            } else {
                iVer2 = iVer2 * 10;
            }
            ++i;
        }
        if (iVer1 < iVer2)
            return -1;
        if (iVer1 > iVer2)
            return 1;

        return 0;
    }
    
    public static void main(String[] args) {
        CompareVersionNums c = new CompareVersionNums();
        c.compareVersion("0.1", "1.1");
    }
}
