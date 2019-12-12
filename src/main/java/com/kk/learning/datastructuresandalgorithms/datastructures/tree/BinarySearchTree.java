package com.kk.learning.datastructuresandalgorithms.datastructures.tree;


public class BinarySearchTree {
    private TreeNode root;

    public void insertNode(Integer data){
        if( root == null) root = new TreeNode(data);
        else {
            root.insert(data);
        }
    }

    public TreeNode find(Integer data){
        if(root != null) return root.find(data);
        else return null;
    }

    public TreeNode deleteNode(Integer data){
        return null;
    }

    public String inOrderTravers(){
        if (root != null) return "["+ root.inOrderTravers()+"]";
        return null;
    }

    public String preOrderTravers() {
        if(root != null) return "[" + root.preOrderTravers() + "]";
        return null;
    }

    public String postOrderTravers() {
        if(root != null) return "[" + root.postOrderTravers() + "]";
        return null;
    }
}
