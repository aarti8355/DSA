package com.company;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
    }
}
public class Main {
static boolean childSum(Node root){
    if(root==null){
        return true;
    }
    if(root.left==null && root.right==null){
        return true;
    }
    int sum=0;
    if(root.left!=null){
        sum+=root.left.data;
    }
    if(root.right!=null){
        sum+=root.right.data;
    }
    return (root.data==sum && childSum(root.left) && childSum(root.right));
}
    public static void main(String[] args) {
	// write your code here
        Node root=new Node(20);
        root.left=new Node(30);
        root.right=new Node(40);
        root.left.left=new Node(50);
        root.left.right=new Node(60);
        root.right.left=new Node(70);
        root.right.right=new Node(80);
        System.out.println(childSum(root));
    }
}
