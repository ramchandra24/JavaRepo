package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinTreeFromPreAndIn {
    public static Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    public static int preIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Integer index = 0;
        for (Integer val : inorder) {
            indexMap.put(val, index);
            index++;
        }
        return buildTreeUtil(preorder, inorder, 0, inorder.length);
    }

    public static TreeNode buildTreeUtil(int[] preorder, int[] inorder, int left, int right) {
        if (left == right) {
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preIndex]);
        int inIndex = indexMap.get(preorder[preIndex]);
        System.out.println(inIndex);
        ++preIndex;

        curr.left = buildTreeUtil(preorder, inorder, left, inIndex);
        curr.right = buildTreeUtil(preorder, inorder, inIndex+1, right);

        return curr;
    }

    public static int findInorder(int[] inorder, int preOrderVal) {
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == preOrderVal) {
                return i;
            }
        }
        return -1;
    }


    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = BinTreeFromPreAndIn.buildTree(preorder, inorder);
        BinTreeFromPreAndIn.inorder(root);
        return;
    }
}
