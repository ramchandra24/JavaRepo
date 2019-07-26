package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathToLeafSum {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Integer curr = 0;
        List<Integer> path = new ArrayList<Integer>();
        pathSumUtil(result, path, root, sum);
        return result;
    }

    public static void pathSumUtil(List<List<Integer>> result, List<Integer> path, TreeNode root, Integer sum) {
        if (root == null) {
            return;
        }
        path.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        else {
            pathSumUtil(result, path, root.left, sum - root.val);
            pathSumUtil(result, path, root.right, sum - root.val);
        }
        path.remove(path.size() - 1);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(11);
        TreeNode d = new TreeNode(13);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(2);
        TreeNode h = new TreeNode(5);
        TreeNode i = new TreeNode(1);

        root.left = a;
        root.right = b;

        a.left = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;
        List<List<Integer>> result = PathToLeafSum.pathSum(root, 22);

        for (List<Integer> list : result) {
            for (Integer in : list) {
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }

}
