package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinTreeFromPreAndIn {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = null;
        int inIndex = 0;
        int preIndex = 0;
        //        if (preorder.length < 1) {
        //            return null;
        //        }
        //        result = new TreeNode(preorder[0]);
        //        ++preIndex;
        //        inIndex = findInorder(0, inorder, preorder[0]);
        return buildTreeUtil(result, preIndex, preorder, inorder);
        //return result;
    }

    public static TreeNode buildTreeUtil(TreeNode result, int preIndex, int[] preorder, int[] inorder) {
        if (preIndex >= preorder.length) {
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preIndex]);
        int inIndex = findInorder(inorder, preorder[preIndex]);
        ++preIndex;
        if (inIndex > 0) {
            curr.left = buildTreeUtil(curr, preIndex, preorder, Arrays.copyOfRange(inorder, 0, inIndex));
            curr.right = buildTreeUtil(curr, preIndex, preorder, Arrays.copyOfRange(inorder, inIndex+1, inorder.length));
        }
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
        System.out.println(root.val + " ");
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
