package com.company;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
    }
}
    public class Main {
  /* static ArrayList<ArrayList<Integer>>level_line_by_line(Node node){
       Queue<Node> q = new LinkedList<>();
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       ArrayList<Integer> level = new ArrayList<Integer>();
       q.add(node);
       while(q.size()>0)
       { node = q.peek();
               q.poll();
               level.add(node.data);
               if(node.left != null)
                   q.add(node.left);
               if(node.right != null)
                   q.add(node.right);
               q.size()--;
           }
           
           result.add(level);

       
       return result;

   }*/

   //Method 2
   static ArrayList<ArrayList<Integer>> levelOrder(Node node) {
       Queue<Node> q = new LinkedList<>();
       q.add(node);
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       while(!q.isEmpty()){
           int count=q.size();
           ArrayList<Integer> list=new ArrayList<>();
           for(int i=0;i<count;i++){
               Node curr=q.poll();
               list.add(curr.data);
               if(curr.left!=null)
                   q.add(curr.left);
               if(curr.right!=null)
                   q.add(curr.right);
               count--;
           }
          result.add(list);
       }
       return result;
   }
   static int size_Of_BinaryTree(Node root){
       if(root==null)
           return 0;
           return 1+size_Of_BinaryTree(root.left)+size_Of_BinaryTree(root.right);
   }
   static int max_in_BTree(Node root){
       if(root==null)
           return Integer.MIN_VALUE;
       return Math.max(root.data,Math.max(max_in_BTree(root.left),max_in_BTree(root.right)));
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
        //System.out.println(level_line_by_line(root));
        System.out.println();
        //level_lineByline(root);
        System.out.println(levelOrder(root));
        System.out.println();
        System.out.println(size_Of_BinaryTree(root));
        System.out.println();
        System.out.println(max_in_BTree(root));
    }
}
