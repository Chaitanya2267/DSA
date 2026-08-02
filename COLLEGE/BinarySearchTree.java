class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root;

    // Insert
    Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);
        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        return node;
    }

    // Delete
    Node delete(Node node, int key) {
        if (node == null)
            return null;

        if (key < node.data)
            node.left = delete(node.left, key);
        else if (key > node.data)
            node.right = delete(node.right, key);
        else {
            // Case 1: no child
            if (node.left == null && node.right == null)
                return null;
            // Case 2: one child
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            // Case 3: two children
            Node successor = minValueNode(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }
        return node;
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Traversals
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = { 50, 30, 70, 20, 40, 60, 80 };
        for (int v : values)
            bst.root = bst.insert(bst.root, v);

        System.out.println("Inorder (sorted):");
        bst.inorder(bst.root);

        System.out.println("\nPreorder:");
        bst.preorder(bst.root);

        System.out.println("\nPostorder:");
        bst.postorder(bst.root);

        // Deletion demo
        System.out.println("\n\nDeleting 20...");
        bst.root = bst.delete(bst.root, 20);
        bst.inorder(bst.root);

        System.out.println("\nDeleting 30...");
        bst.root = bst.delete(bst.root, 30);
        bst.inorder(bst.root);

        System.out.println("\nDeleting 50...");
        bst.root = bst.delete(bst.root, 50);
        bst.inorder(bst.root);
    }
}
