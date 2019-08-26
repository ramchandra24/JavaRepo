package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Codec {

    public String serialize(TreeNode root) {
        Stack<String> result = new Stack();
        preorder(root, result);
        String output = new String();
        while (!result.isEmpty()) {
            String temp = result.pop();
            //System.out.println(temp);
            output = temp + output;
        }
        return output;
    }
    
    void preorder(TreeNode root, Stack<String> result) {
        if (root == null) {
            result.add("null");
            //System.out.println(result);
            return;
        }
        //System.out.println(result);
        //result.add("(");
        result.add(Integer.toString(root.val));
        result.add(",");
        //result.add("(");
        preorder(root.left, result);
        result.add(",");
        preorder(root.right, result);
        //result.add(")");
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> s = Arrays.asList(data.split(","));
        int[] index = new int[1];
        return deserializeUtil(s, index);
    }

    public TreeNode deserializeUtil(List<String> data, int[] index) {
        if (data.get(index[0]).compareTo("null") == 0) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data.get(index[0])));
        index[0] += 1;
        node.left = deserializeUtil(data, index);
        index[0] += 1;
        node.right = deserializeUtil(data, index);
        return node;
    }

    public static void main(String[] args) {
      Codec codec = new Codec();
      TreeNode root = new TreeNode(4);
      TreeNode a = new TreeNode(3);
      TreeNode b = new TreeNode(1);
      TreeNode c = new TreeNode(2);
      TreeNode d = new TreeNode(6);
      TreeNode e = new TreeNode(5);
      TreeNode f = new TreeNode(7);
      
      root.left = c;
      root.right = d;
      
      c.left = b;
      c.right = a;
      
      d.left = e;
      d.right = f;
      
      System.out.println(codec.serialize(root));
      TreeNode.inorder(codec.deserialize(codec.serialize(root)));
      //TreeNode.inorder(root);
    }
}
