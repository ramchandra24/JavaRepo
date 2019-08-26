package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return "";
        }
        String result = new String();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                result += "N";
                q.add(null);
                q.add(null);
            }
            else {
                result += Integer.toString(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            result += ",";
        }
        return result;
    }
    
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
    
    

    int findSpecial(int begin, String data) {
        for (int i = begin; i < data.length(); ++i) {
            if (data.charAt(i) == '(' || data.charAt(i) == ',' || data.charAt(i) == ')') {
                return i;
            }
        }
        return -1;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeUtil(data, 0);
    }

    public TreeNode deserializeUtil(String data, int begin) {
        if (begin >= data.length() || begin < 0) {
            return null;
        }
        int curr = findSpecial(begin, data);
        String snum = data.substring(begin, curr);
        System.out.println(snum);
        if (snum.compareTo("null") == 0) {
            return null;
        }
        int num = Integer.parseInt(snum);
        TreeNode node = new TreeNode(num);
        if (data.charAt(curr) == '(') {
            System.out.println("left");
            node.left = deserializeUtil(data, curr+1);
        }
        System.out.println(node.val + "right");
        begin = curr + 1;
        curr = findSpecial(begin, data);
        snum = data.substring(begin, curr);
        System.out.println(snum);
        if (snum.compareTo("null") == 0) {
            node.right = null;
        }
        else {
            num = Integer.parseInt(snum);
            node.right = deserializeUtil(data, curr+1);
        }
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
