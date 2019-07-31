package LeetCode;

public class TreeNodeConnect {
    public static Node connect(Node root) {
        connectUtil(root);
        return root;
    }
    
    public static void connectUtil(Node root) {
        if (root == null || root.left == null) {
            return;
        }
        Node prev = null;
        Node temp = root;
        while(temp != null) {
            if (prev != null) {
                prev.next = temp.left;
            }
            temp.left.next = temp.right;
            prev = temp.right;
            temp = temp.next;
        }
        prev.next = null;
        connectUtil(root.left);
    }
    
    public static void traverse(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
        traverse(root.left);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(6);
        Node f = new Node(7);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;
        TreeNodeConnect.connect(root);
        traverse(root);
    }
}
