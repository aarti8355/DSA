package com.company;

public class Main {
   static class Node {
         int data;
         Node left;
         Node right;

         Node(int d) {
             data = d;
             left = right = null;
         }
     }
   static class BinaryTree{
      public boolean findPath(Node root,int[] sequence){
           if(root==null)
               return sequence.length==0;

           return findPathInSequence(root,sequence,0);
       }
        boolean findPathInSequence(Node currentNode,int[] sequence,int sequenceIndex){
           if(currentNode==null){
               return false;
           }
           if (sequenceIndex>=sequence.length ||currentNode.data != sequence[sequenceIndex]) {
               return false;
           }
           if(currentNode.left==null && currentNode.right==null && sequenceIndex==sequence.length-1){
               return true;
           }
           return findPathInSequence(currentNode.left,sequence,sequenceIndex+1) || findPathInSequence(currentNode.right,sequence,sequenceIndex+1);
       }
     }
    public static void main(String[] args) {
	BinaryTree b=new BinaryTree();
	Node root;
	root=new Node(1);
	root.left=new Node(2);
	root.right=new Node(3);
	root.left.left=new Node(4);
	root.right.right=new Node(5);
	root.left.right=new Node(6);
	root.right.left=new Node(8);
	int[] sequence={1,3,5};
	b.findPath(root,sequence);
        System.out.println("Tree has following sequence " +
                ""+b.findPath(root,sequence));
    }
}
