package com.kk.learning.datastructuresandalgorithms.datastructures.tree.avl;

public class AvlTreeNode {

    private Integer data;
    private AvlTreeNode leftChild;
    private AvlTreeNode rightChild;
    private int height;

    public AvlTreeNode(Integer data) {
        this.data = data;
        this.height = 0;
    }

    public Integer getData() {
        return data;
    }

    public AvlTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public AvlTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public AvlTreeNode find(Integer data) {
        if (this.data == data) return this;
        else if (data > this.data && this.rightChild != null) return this.rightChild.find(data);
        else if (data < this.data && this.leftChild != null) return this.leftChild.find(data);
        else return null;
    }


    public String inOrderTravers() {

        String result = "";
        if (this.leftChild != null) result += this.leftChild.inOrderTravers();
        result += data.toString() + ",";
        if (this.rightChild != null) result += this.rightChild.inOrderTravers();
        return result;
    }

    public String preOrderTravers() {
        String result = this.data.toString() + ",";
        if (leftChild != null) result += leftChild.preOrderTravers();
        if (rightChild != null) result += rightChild.preOrderTravers();
        return result;
    }

    public String postOrderTravers() {
        String result = "";
        if (leftChild != null) result += leftChild.postOrderTravers();
        if (rightChild != null) result += rightChild.postOrderTravers();
        result += this.data.toString() + ",";
        return result;
    }


    public int avlInsert(Integer data) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (this.data > data) {
            if (this.rightChild != null) {
                rightHeight = this.rightChild.avlInsert(data);
            } else {
                this.rightChild = new AvlTreeNode(data);
                rightHeight = rightHeight + 1;
            }
        } else {
            if (this.leftChild != null) {
                leftHeight = this.leftChild.avlInsert(data);
            } else {
                this.leftChild = new AvlTreeNode(data);
                leftHeight = leftHeight + 1;
            }
        }
        this.height = Math.max(rightHeight, leftHeight) ;
        return height + 1;
    }

}
