import Part2.BST;

public class AspectJMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Binary Search Tree with AspectJ for Concurrency addition");
        System.out.println("-----------------------------------------------------------");
        BST.createTestBST();
        System.out.print("In-Order : ");
        BST.traverseInOrder(BST.getRoot());
        System.out.print("\nPre-Order : ");
        BST.traversePreOrder(BST.getRoot());
        System.out.print("\nPost-Order : ");
        BST.traversePostOrder(BST.getRoot());
        System.out.println("\n");

        new Thread(() -> {
            BST.insert(23);
            BST.insert(45);
            BST.insert(33);
            BST.lookUp(3);
            BST.insert(31);
            BST.insert(50);
            BST.lookUp(6);
        }).start();

        new Thread(() -> {
            BST.remove(23);
            BST.remove(45);
            BST.remove(33);
            BST.remove(31);
            BST.remove(50);
        }).start();
    }
}
