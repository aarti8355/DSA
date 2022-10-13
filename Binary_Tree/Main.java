package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
    }
}
public class Main {
    static void print_Spiral(Node root){
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.add(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                Node temp=s1.peek();
                s1.pop();
                System.out.print(temp.data+" ");
                if(temp.right!=null){
                    s2.add(temp.right);
                }
                if(temp.left!=null){
                    s2.add(temp.left);
                }
            }
            while(!s2.isEmpty()){
                Node temp=s2.peek();
                s2.pop();
                System.out.print(temp.data+" ");
                if(temp.left!=null){
                    s1.add(temp.left);
                }
                if(temp.right!=null){
                    s1.add(temp.right);
                }
            }
        }
    }
static void tree_in_spiral(Node root){
    if(root==null)return;
    Queue<Node> q=new LinkedList<>();
    Stack<Integer> s=new Stack<>();
    boolean reverse=false;
    q.add(root);
    while(!q.isEmpty()){
        int count=q.size();
        for(int i=0;i<count;i++){
            Node curr=q.poll();
            if(reverse){
                s.add(curr.data);
            }
            else{
                System.out.print(curr.data+" ");
            }
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        if(reverse){
            while(!s.isEmpty()){
                System.out.print(s.pop()+" ");
            }
        }
        reverse=!reverse;
        System.out.println();
    }
}
    public static void main(String[] args) {
	// write your code here
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        tree_in_spiral(root);
        print_Spiral(root);
    }
}
