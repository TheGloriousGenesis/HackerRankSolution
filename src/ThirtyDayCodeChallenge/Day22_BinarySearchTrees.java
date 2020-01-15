package ThirtyDayCodeChallenge;

import java.util.Scanner;

public class Day22_BinarySearchTrees {

// learnt that the state of a recursive method for each iteration is
    // kept for the previous iteration so values from call 2 can be added
    // to call 1 once call 2 is completed
    public static int getHeight(Node root){
        int heightLeft = 0;
        int heightRight = 0;
        if (root == null) {
            return -1;
        }
        Node left = root.left;
        Node right = root.right;
        if (left != null) {
            heightLeft =+ getHeight(left) + 1;
        }
        if (right != null) {
            heightRight =+ getHeight(right) + 1;
        }

        return heightLeft > heightRight ? heightLeft : heightRight;
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Node root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }

    static class Node{
        Node left,right;
        int data;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
}