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
    static void inorder(Node root) {
        if (root!=null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    static int preIndex=0;
static Node construct_BTree_From_Inorder_Preorder(int[] in,int[] pre,int is,int ie){
    if(is>ie)
        return null;
    Node root=new Node(pre[preIndex++]);
    int inIndex=is;
    for(int i=is;i<=ie;i++){
        if(in[i]==root.data){
            inIndex=i;
            break;
        }
    }
root.left=construct_BTree_From_Inorder_Preorder(in,pre,is,inIndex-1);
    root.right=construct_BTree_From_Inorder_Preorder(in,pre,inIndex+1,ie);
    return root;
}
    public static void main(String[] args) {
	// write your code here
        int in[]={20,10,40,30,50};
        int pre[]={10,20,30,40,50};
        int n= in.length;
        Node root=construct_BTree_From_Inorder_Preorder(in, pre, 0, n-1);
        inorder(root);
    }
}
