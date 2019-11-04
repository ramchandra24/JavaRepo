package LeetCode;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trimUtil(root, L, R);
    }

    private TreeNode trimUtil(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        root.left = trimUtil(root.left, L, R);
        root.right = trimUtil(root.right, L, R);
        if (root != null) {
            if (root.val < L) {
                root = root.right;
            } else if (root.val > R) {
                root = root.left;
            }
        }
        return root;
    }
}
