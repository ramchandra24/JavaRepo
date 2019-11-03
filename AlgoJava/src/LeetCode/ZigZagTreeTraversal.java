package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTreeTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        q.add(root);
        boolean zigzag = true;
        while (q.isEmpty() == false) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int level = q.size();
            for (int i = 0; i < level; ++i) {
                TreeNode node = q.poll();
                if (zigzag == false) {
                    levelList.addFirst(node.val);
                } else {
                    levelList.addLast(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            zigzag = !zigzag;
            result.add(new ArrayList<>(levelList));
        }
        return result;
    }
}
