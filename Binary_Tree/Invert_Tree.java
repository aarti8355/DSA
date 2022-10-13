package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
   static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    static Node root;
    static Node temp=root;
    static Node insert(Node root,int key){
        if(temp==null){
            root=new Node(key);
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            temp=queue.peek();
            queue.remove();
            if(temp.left==null){
                temp.left=new Node(key);
                break;
            }
            else{
                queue.add(temp.left);
            }
            if(temp.right==null){
                temp.right=new Node(key);
                break;
            }
            else{
                queue.add(temp.right);
            }
        }
        return root;
    }
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static Node invert_Tree(Node root){
          Queue<Node> queue=new LinkedList<>();
          queue.add(root);
          while(!queue.isEmpty()){
              Node a=queue.poll();
              Node temp=a.left;
              a.left=a.right;
              a.right=temp;
              if(a.left!=null)
                  queue.add(a.left);
              if(a.right!=null)
              queue.add(a.right);
          }
          return root;
      }
    public static void main(String[] args) {
        {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            invert_Tree(root);
            preorder(root);
        }
    }
    }

