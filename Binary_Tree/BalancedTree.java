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
static int balance_Tree(Node root){
    if(root==null){
        return 0;
    }
    int lh=balance_Tree(root.left);
    if(lh==-1){
        return -1;
    }
    int rh=balance_Tree(root.right);
    if(rh==-1){
        return -1;
    }
    if(Math.abs(lh-rh)>1){
        return -1;
    }
    else{
        return Math.max(lh,rh)+1;
    }
}
static int maximum_width(Node root){
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    int res=0;
    while(!q.isEmpty()){
        int count=q.size();
        for(int i=0;i<count;i++){
            Node curr=q.poll();
            res=Math.max(count,res);
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }
    return res;
}
    public static void main(String[] args) {
	// write your code here
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(30);
        root.right.left=new Node(15);
        root.right.right=new Node(20);
        if(balance_Tree(root)>0)
            System.out.print("Balanced");
        else
            System.out.print("Not Balanced");
        System.out.println();
        System.out.println(maximum_width(root));

    }
}
