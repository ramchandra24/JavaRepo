package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        boolean zigzag = false;
        while (q.isEmpty() == false) {
            List<Integer> levelList = new ArrayList<Integer>();
            int level = q.size();
            for (int i=0; i<level; ++i) {
                TreeNode node = q.poll();
                if (zigzag == false) {
                    levelList.add(0, node.val);
                }
                else {
                    levelList.add(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            zigzag = !zigzag;
            result.add(levelList);
        }
        return result;
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

        List<List<Integer>> res = ZigzagTraversal.levelOrder(t[0]);
        for (List<Integer> l : res) {
            for (int num : l) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }

}
