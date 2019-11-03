package LeetCode;

public class PopulatingNextPtrs {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        connectUtil(root);
        return root;
    }
    
    private void connectUtil(Node root) {
        if (root == null || root.left == null) {
            return;
        }
        Node temp = root;
        Node prev = null;
        while (temp != null) {
            if (prev != null) {
                prev.next = temp.left;
            }
            temp.left.right = temp.right;
            prev = temp.right;
            temp = temp.next;
        }
        prev.next = null;
        connectUtil(root.left);
    }
}
