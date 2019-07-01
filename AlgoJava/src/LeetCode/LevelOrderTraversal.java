package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int heightOfTree = height(root);
        List<List<Integer>> result = new ArrayList<>(heightOfTree);
        for (int i = 0; i < heightOfTree; ++i) {
            result.add(new ArrayList<Integer>());
        }
        q.add(root);
        result.get(0).add(root.val);
        while (q.isEmpty() == false) {
            TreeNode node = q.poll();
            int arrIndex = LevelOrderTraversal.distFromRoot(root, node.val) + 1;
            
            if (node.left != null) {
                result.get(arrIndex).add(node.left.val);
                q.add(node.left);
            }
            if (node.right != null) {
                result.get(arrIndex).add(node.right.val);
                q.add(node.right);
            }
        }
        return result;
    }
    
    private static int height(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return (1 + (lh > rh? lh: rh));
    }
    
    private static int distFromRoot(TreeNode root, int val) {
        
        if (root == null) {
            return -1;
        }
        int dist = -1;
        if (root.val == val || (dist = distFromRoot(root.left, val)) >= 0
                || (dist = distFromRoot(root.right, val)) >= 0) {
            return dist + 1;
        }
        return dist;
    }
    
    public static void main(String[] args) {
        TreeNode[] t = new TreeNode[8];
        t[0] = new TreeNode(3);
        t[1] = new TreeNode(4);
        t[2] = new TreeNode(5);
        t[3] = new TreeNode(-7);
        t[4] = new TreeNode(-6);
        t[5] = new TreeNode(-7);
        t[6] = new TreeNode(-5);
        t[7] = new TreeNode(-4);
        
        t[0].left = t[1];
        t[0].right = t[2];
        t[1].left = t[3];
        t[1].right = t[4];
        t[3].left = t[5];
        t[4].left = t[6];
        t[5].left = t[7];
        
        List<List<Integer>> res = LevelOrderTraversal.levelOrder(t[0]);
        for (List<Integer> l : res) {
            for (int num : l) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }
}
