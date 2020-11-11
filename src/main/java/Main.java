import Part1.File.File;
import Part1.File.Type.ImageSubType.Png;
import Part1.File.Type.VideoSubType.Avi;
import Part1.File.Type.VideoSubType.Mp4;
import Part1.File.TypeHandler;
import Part1.Visitor.Visitor;
import Part2.BST;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Part1.Visitor with Dynamic proxy");
        System.out.println("------------------------------------------------");
        File file = new Mp4();
        File file1 = new Avi();
        File file2 = new Png();

        Class[] interfaces = new Class[1];
        interfaces[0] = Visitor.class;
        Visitor proxy = (Visitor) Proxy.newProxyInstance(Main.class.getClassLoader(), interfaces, new TypeHandler());
        proxy.visit(file);
        proxy.visit(file1);
        proxy.visit(file2);

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
