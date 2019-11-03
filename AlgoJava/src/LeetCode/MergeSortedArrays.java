package LeetCode;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        if (p1 < 0) {
            while (p2 >= 0) {
                nums1[p2] = nums2[p2];
                --p2;
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays m = new MergeSortedArrays();
        int[] ar1 = new int[] { 1, 2, 3, 0, 0, 0 };
        m.merge(ar1, 3, new int[] { 2, 5, 6 }, 3);
        for (int num : ar1) {
            System.out.println(num);
        }
    }
}
