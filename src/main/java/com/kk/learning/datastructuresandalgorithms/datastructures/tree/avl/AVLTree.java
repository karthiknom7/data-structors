package com.kk.learning.datastructuresandalgorithms.datastructures.tree.avl;

import com.kk.learning.datastructuresandalgorithms.datastructures.tree.TreeNode;

public class AVLTree {
    private AvlTreeNode root;

    public void insertNode(Integer data){
        if( root == null) root = new AvlTreeNode(data);
        else {
            root.avlInsert(data);
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
}
