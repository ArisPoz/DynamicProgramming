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

        System.out.println("\n\nPart2.Binary Search Tree with AspectJ for Concurrency addition");
        System.out.println("-----------------------------------------------------------");

        BST.insert(3);
        BST.insert(1);
        BST.insert(2);
        BST.insert(4);

        new Thread(() -> {
            BST.insert(9);
            BST.lookUp(3);
            BST.remove(4);
        }).start();

        new Thread(() -> {
            BST.insert(3);
            BST.lookUp(2);
            BST.lookUp(2);
            BST.lookUp(2);
            BST.remove(1);
        }).start();
    }
}
