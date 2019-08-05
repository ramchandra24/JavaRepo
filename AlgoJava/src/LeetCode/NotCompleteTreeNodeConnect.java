package LeetCode;

public class NotCompleteTreeNodeConnect {

    public static Node connect(Node root) {
        connectUtil(root);
        return root;
    }

    public static void connectUtil(Node root) {
        if (root == null) {
            return;
        }
        Node head = null;
        Node prev = null;
        Node cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
    }

    public static void traverse(Node root) {
        if (root == null) return;
        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
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
        //a.left = c;
        //a.right = d;
        b.left = e;
        b.right = f;
        NotCompleteTreeNodeConnect.connect(root);
        NotCompleteTreeNodeConnect.traverse(root);
    }
}
