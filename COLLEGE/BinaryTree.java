class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;

    // Traversals
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Insert (manual: attach to left or right)
    Node insertLeft(Node parent, int data) {
        parent.left = new Node(data);
        return parent.left;
    }

    Node insertRight(Node parent, int data) {
        parent.right = new Node(data);
        return parent.right;
    }

    // Delete: replace node with null (simple demo)
    void deleteNode(Node parent, boolean isLeft) {
        if (parent == null)
            return;
        if (isLeft)
            parent.left = null;
        else
            parent.right = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);

        Node left = tree.insertLeft(tree.root, 2);
        Node right = tree.insertRight(tree.root, 3);

        tree.insertLeft(left, 4);
        tree.insertRight(left, 5);

        tree.insertLeft(right, 6);
        tree.insertRight(right, 7);

        // BEFORE deletion
        System.out.println("Preorder before deletion:");
        tree.preorder(tree.root);

        System.out.println("\nInorder before deletion:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder before deletion:");
        tree.postorder(tree.root);

        // Delete left subtree
        tree.deleteNode(tree.root, true);

        System.out.println("\n\nAfter deleting left subtree:");

        System.out.println("Preorder:");
        tree.preorder(tree.root);

        System.out.println("\nInorder:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder:");
        tree.postorder(tree.root);

        // Delete right subtree
        tree.deleteNode(tree.root, false);

        System.out.println("\n\nAfter deleting right subtree:");

        System.out.println("Preorder:");
        tree.preorder(tree.root);

        System.out.println("\nInorder:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder:");
        tree.postorder(tree.root);
    }
}
