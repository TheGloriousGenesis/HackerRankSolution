package ThirtyDayCodeChallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day23_BSTLevelOrderTraversal {

    static void inOrder(Day22_BinarySearchTrees.Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.printf("%s ", root.data);
            inOrder(root.right);
        }
    }

    static void postOrder(Day22_BinarySearchTrees.Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%s ", root.data);
        }
    }

    static void preOrder(Day22_BinarySearchTrees.Node root) {
        if (root != null) {
            System.out.printf("%s ", root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static void levelOrder(Day22_BinarySearchTrees.Node root){
        Queue<Day22_BinarySearchTrees.Node> queue = new LinkedList<Day22_BinarySearchTrees.Node>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Day22_BinarySearchTrees.Node node = queue.remove();
            System.out.printf("%s ", node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Day22_BinarySearchTrees.Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=Day22_BinarySearchTrees.insert(root,data);
        }

        System.out.printf("%s: ", "inOrder");
        inOrder(root);
        System.out.println();
        System.out.printf("%s: ", "postOrder");
        postOrder(root);
        System.out.println();
        System.out.printf("%s: ", "preOrder");
        preOrder(root);
        System.out.println();
        System.out.printf("%s: ", "levelOrder");
        levelOrder(root);
        System.out.println();
    }
}