package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int currLevel = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int level = q.size();
            int levelSum = 0;
            for (int i = 0; i < level; ++i) {
                TreeNode curr = q.poll();
                levelSum += curr.val;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            if (levelSum > maxSum) {
                System.out.println(levelSum);
                maxSum = levelSum;
                maxLevel = currLevel;
            }
            currLevel++;
        }
        return maxLevel;
    }
}
