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

    public void deleteNode(Integer data){
        if(root == null) return;
        if(data == root.getData()){
            if(root.getRightChild() == null && root.getLeftChild() == null){
                root = null;
                return;
            }
            TreeNode newRoot = root.getRightChild();
            TreeNode parent = root;
            while (newRoot.getLeftChild() != null){
                parent = newRoot;
                newRoot = newRoot.getLeftChild();
            }
            if(newRoot.getRightChild() != null){
                parent.setLeftChild(newRoot.getRightChild());
            }else {
                parent.setLeftChild(null);
            }
            newRoot.setLeftChild(root.getLeftChild());
            newRoot.setRightChild(root.getRightChild());
            root.setRightChild(null);
            root.setLeftChild(null);
            root = newRoot;
        }else {
            root.delete(data);
        }

    }

    public String inOrderTravers(){
        if (root != null) return "["+ root.inOrderTravers()+"]";
        return "[]";
    }

    public String preOrderTravers() {
        if(root != null) return "[" + root.preOrderTravers() + "]";
        return "[]";
    }

    public String postOrderTravers() {
        if(root != null) return "[" + root.postOrderTravers() + "]";
        return "[]";
    }

    public int countLeafNodes(){
        if (root == null) return 0;
        return root.countLeafNodes();
    }

    public int heightOfTree(){
        if(root == null) return 0;
        return root.heightOfTree();
    }
}
