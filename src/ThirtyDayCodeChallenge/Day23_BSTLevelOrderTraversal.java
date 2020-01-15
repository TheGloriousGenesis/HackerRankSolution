package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day23_BSTLevelOrderTraversal {

    static void levelOrder(Day22_BinarySearchTrees.Node root){
        if (root == null) {
            return;
        }

        System.out.printf("%s ", root.data);
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Day22_BinarySearchTrees.Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=Day22_BinarySearchTrees.insert(root,data);
        }
        levelOrder(root);
    }
}