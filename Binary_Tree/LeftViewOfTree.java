package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
    }
}
public class Main {
//Method 1
    static int maxLevel;
    static void left_view(Node root,int level){
    if(root==null){
        return;

    }
    if(maxLevel<level){
        System.out.println(root.data);
        maxLevel=level;
    }
    left_view(root.left,level+1);
    left_view(root.right,level+1);
    }
    //Method 2
    static void left_view_BTree(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            Node curr;
            for(int i=0;i<count;i++){
                curr=q.poll();
                if(i==0) {
                    System.out.println(curr.data + " ");
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                }
            }
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
        int level=1;
        left_view(root,level);
        System.out.println();
        left_view_BTree(root);
    }
}
