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
    static Node previous=null;
 static Node convert_binaryTree_to_DoublyLL(Node root){
     if(root==null)
         return root;
     Node head=convert_binaryTree_to_DoublyLL(root.left);
     if(previous==null){
         head=root;
     }
     else{
         root.left=previous;
         previous.right=root;
     }
     previous=root;
     convert_binaryTree_to_DoublyLL(root.right);
     return head;
 }
    static void printList(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }
    public static void main(String[] args) {
	// write your code here
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(30);
        root.right.left=new Node(15);
        root.right.right=new Node(20);
        Node head=convert_binaryTree_to_DoublyLL(root);
        printList(head);

    }
}
