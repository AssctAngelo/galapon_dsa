package galapon_binarytree;

import sun.applet.Main;

class Node {
  int key;
  Node left, right;

   
  public Node(int item) {
      key = item;
      left = right = null;
  }
}
public class Galapon_Binarytree
{
    public static void main(String[] args)
    {
        Galapon_Binarytree tree = new Galapon_Binarytree();

        tree.root = new Node(8);
        tree.root.left = new Node(7);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        tree.root.left.right.left = new Node(6);
        tree.root.left.right.right = new Node(3);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);
        tree.traverseTree(tree.root);
    }
    
    Node root;
    
    public void traverseTree(Node node) {
        if (node != null) {
            this.traverseTree(node.left);
            System.out.print(" " + node.key);
            this.traverseTree(node.right);
            
        }
    }
}