package LeetCode;
import java.util.Arrays;

public class BinTreeFromInorderAndPostorder {

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        return buildTreeUtil(postorder, inorder);
    }

    public static TreeNode buildTreeUtil(int[] postorder, int[] inorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(val);
        int inIndex = findInorder(inorder, val);
        root.right = buildTreeUtil(Arrays.copyOfRange(postorder, inIndex, postorder.length - 1), 
                Arrays.copyOfRange(inorder, inIndex+1, inorder.length));
        root.left = buildTreeUtil(Arrays.copyOfRange(postorder, 0, inIndex), 
                Arrays.copyOfRange(inorder, 0, inIndex));
        return root;
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
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = BinTreeFromInorderAndPostorder.buildTree(postorder, inorder);
        BinTreeFromInorderAndPostorder.inorder(root);
        return;
    }
}
