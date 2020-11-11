package Part2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BSTAspect {
    Concurrent concurrent = new Concurrent();

    @Before("execution (public static void BST.insert(..))")
    public void beforeInsertion() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " [Insert Enter]");
        concurrent.enterWriter();
    }

    @After("execution (public static void BST.insert(..))")
    public void afterInsertion() {
        System.out.println(Thread.currentThread().getName() + " [Insert Exit]");
        concurrent.exitWriter();
    }

    @Before("execution (public static void BST.remove(..))")
    public void beforeDeletion() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " [Remove Enter]");
        concurrent.enterWriter();
    }

    @After("execution (public static void BST.remove(..))")
    public void afterDeletion() {
        System.out.println(Thread.currentThread().getName() + " [Remove Exit]");
        concurrent.exitWriter();
    }

    @Before("execution (public static Node BST.lookUp(..))")
    public void beforeLookUp() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " [LookUp Enter]");
        concurrent.enterReader();
    }

    @After("execution (public static Node BST.lookUp(..))")
    public void afterLookUp() {
        System.out.println(Thread.currentThread().getName() + " [LookUp Exit]");
        concurrent.exitReader();
    }

    @Before("execution (public static void BST.traverseInOrder(..))")
    public void beforeTraverseInOrder() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " [Traverse Enter]");
        concurrent.enterReader();
    }

    @After("execution (public static void BST.traverseInOrder(..))")
    public void afterTraverseInOrder() {
        System.out.println(Thread.currentThread().getName() + " [Traverse Exit]");
        concurrent.exitReader();
    }

    @Before("execution (public static void BST.traversePostOrder(..))")
    public void beforeTraversePostOrder() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " [Traverse Enter]");
        concurrent.enterReader();
    }

    @After("execution (public static void BST.traversePostOrder(..))")
    public void afterTraversePostOrder() {
        System.out.println(Thread.currentThread().getName() + " [Traverse Exit]");
        concurrent.exitReader();
    }

    @Before("execution (public static void BST.traversePreOrder(..))")
    public void beforeTraversePreOrder() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " [Traverse Enter]");
        concurrent.enterReader();
    }

    @After("execution (public static void BST.traversePreOrder(..))")
    public void afterTraversePreOrder() {
        System.out.println(Thread.currentThread().getName() + " [Traverse Exit]");
        concurrent.exitReader();
    }
}
