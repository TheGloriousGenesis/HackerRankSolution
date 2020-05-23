package Solutions.Medium;

public class CheckIfTreeIsBalanced {

    public static int getHeight(Node root){

        if(root==null)return 0;

        return (1+ Math.max(getHeight(root.left), getHeight(root.right)));

    }

    public static boolean isBalancedNaive(Node root){

        if(root==null)return true;

        int heightdifference = getHeight(root.left)-getHeight(root.right);

        if(Math.abs(heightdifference)>1){

            return false;

        }else{

            return isBalancedNaive(root.left) && isBalancedNaive(root.right);

        }

    }

    public static int checkHeight(Node root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String args[]){

        Node root = new Node(5);

        root.left = new Node(10);

        root.right = new Node(15);

        root.left.left = new Node(20);

        root.left.right = new Node(25);

        root.right.left = new Node(30);

        root.right.right = new Node(35);

//        System.out.println(" Is Tree Balanced : " + (new CheckIfTreeIsBalanced()).isBalancedNaive(root));

        root.right.right.right = new Node (40);

        root.right.right.right.right = new Node (45);

//        System.out.println(" Is Tree Balanced : " + (new CheckIfTreeIsBalanced()).isBalancedNaive(root));
        System.out.println(" Is Tree Balanced : " + ((new CheckIfTreeIsBalanced()).checkHeight(root) != Integer.MIN_VALUE));

    }

}

class Node{

    int data;

    Node left;

    Node right;

    public Node(int data){

        this.data = data;

        this.left = null;

        this.right =null;

    }

}