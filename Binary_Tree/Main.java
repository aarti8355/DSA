package com.company;
//Time Complexity:O(n^2)
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
    }
}
public class Main {
    static int height(Node root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
  static int diameter(Node root){
        if(root==null){return 0;}
      int d1=1+height(root.left)+height(root.right);
      int d2=diameter(root.left);
      int d3=diameter(root.right);
      return Math.max(d1,Math.max(d2,d3));
  }
  static int res=0;
  static int hei(Node root){
      if(root==null){
            return 0;
        }
        int lh=hei(root.left);
        int rh=hei(root.right);
        res=Math.max(res,1+lh+rh);
        return 1+Math.max(lh,rh);
  }
    public static void main(String[] args) {
	// write your code here
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(60);
        root.right.left.left=new Node(50);
        root.right.right.right=new Node(70);
        System.out.print(diameter(root));
        System.out.println();
        System.out.println("Height: "+hei(root));
        System.out.println("Diameter: "+res);
    }
}
