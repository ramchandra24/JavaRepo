package LeetCode;

public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    
    private static boolean isValidBSTUtil(TreeNode root, long greaterThan, long lessThan) {
        // TODO Auto-generated method stub
        if (root == null) {
            return true;
        }
        if (root.val <= greaterThan || root.val >= lessThan) {
            return false;
        }
        return (isValidBSTUtil(root.left, greaterThan, root.val)
                && isValidBSTUtil(root.right, root.val, lessThan));
    }


    public static void main(String[] args) {
        TreeNode[] t = new TreeNode[7];
        t[0] = new TreeNode(5);
        t[1] = new TreeNode(4);
        t[2] = new TreeNode(7);
        t[3] = new TreeNode(2);
        t[4] = new TreeNode(6);
        t[5] = new TreeNode(3);
        t[6] = new TreeNode(9);
        
        t[0].left = t[1];
        t[0].right = t[2];
        t[1].left = t[3];
        t[1].right = t[4];
        t[2].left = t[5];
        t[2].right = t[6];
        
        System.out.println(IsValidBST.isValidBST(t[0]));
    }
}
