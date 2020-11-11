package Part2;

public class BST {

    private static Node root;

    private BST() {}

    public static BST createTestBST() {
        BST bt = new BST();

        bt.insert(2);
        bt.insert(6);
        bt.insert(7);
        bt.insert(15);
        bt.insert(5);
        bt.insert(4);
        bt.insert(1);
        bt.insert(2);
        bt.insert(11);
        bt.insert(16);
        bt.insert(3);

        return bt;
    }

    public static void insert(int value) {
        root = insert(root, value);
    }

    public static Node lookUp(int value) {
        return lookUp(root, value);
    }

    public static void remove(int value) {
        root = remove(root, value);
    }

    private static Node insert(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }

        if(node.getValue() > value) {
            node.setRight(insert(node.getRight(), value));
        } else if(node.getValue() < value) {
            node.setLeft(insert(node.getLeft(), value));
        }

        return node;
    }

    private static Node lookUp(Node node, int value) {
        if(node.getValue() == value) {
            return node;
        }

        return value > node.getValue()
                ? lookUp(node.getLeft(), value)
                : lookUp(node.getRight(), value);
    }

    private static Node remove(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value == node.getValue()) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }

            int smallestValue = findSmallest(node.getRight());
            node.setValue(smallestValue);
            node.setRight(remove(node.getRight(), smallestValue));
            return node;
        }
        if (value > node.getValue()) {
            node.setLeft(remove(node.getLeft(), value));
            return node;
        }
        node.setRight(remove(node.getRight(), value));
        return node;
    }

    private static int findSmallest(Node node) {
        return node.getLeft() == null ? node.getValue() : findSmallest(node.getLeft());
    }

    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            traverseInOrder(node.getRight());
        }
    }

    public static void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public static void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
        }
    }

    public static Node getRoot() {
        return root;
    }
}
