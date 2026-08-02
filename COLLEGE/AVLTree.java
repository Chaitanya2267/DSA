class AVLTree {

    class Node {
        int value;
        int height;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {

        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    private Node rotate(Node node) {

        // LEFT HEAVY
        if (height(node.left) - height(node.right) > 1) {

            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }

            if (height(node.left.left) - height(node.left.right) < 0) {

                node.left = leftRotate(node.left);

                return rightRotate(node);
            }
        }

        // RIGHT HEAVY
        if (height(node.left) - height(node.right) < -1) {

            if (height(node.right.left) - height(node.right.right) < 0) {
                return leftRotate(node);
            }

            if (height(node.right.left) - height(node.right.right) > 0) {

                node.right = rightRotate(node.right);

                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node p) {

        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;

        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    public Node leftRotate(Node c) {

        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {

        if (node == null) {
            return;
        }

        System.out.println(details + node.value);

        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        tree.display();
    }
}