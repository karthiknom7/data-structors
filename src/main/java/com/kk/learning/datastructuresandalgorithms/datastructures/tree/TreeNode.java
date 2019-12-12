package com.kk.learning.datastructuresandalgorithms.datastructures.tree;

public class TreeNode {

    private Integer data;
    private  TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode find(Integer data){
        if(this.data == data) return this;
        else if(data > this.data && this.rightChild != null) return this.rightChild.find(data);
        else if(data < this.data && this.leftChild != null) return this.leftChild.find(data);
        else return null;
    }

    public void insert(Integer data){
        if(data >= this.data){
            if(this.rightChild == null) this.rightChild = new TreeNode(data);
            else this.rightChild.insert(data);
        }else {
            if(this.leftChild == null) this.leftChild = new TreeNode(data);
            else this.leftChild.insert(data);
        }
    }

    public String inOrderTravers(){

        String result = "";
         if(this.leftChild != null) result += this.leftChild.inOrderTravers();
         result+= data.toString() + ",";
         if(this.rightChild != null) result += this.rightChild.inOrderTravers();
         return result;
    }

    public String preOrderTravers(){
        String result = this.data.toString() + ",";
        if(leftChild != null) result+= leftChild.preOrderTravers();
        if (rightChild != null) result += rightChild.preOrderTravers();
        return result;
    }

    public String postOrderTravers(){
        String result = "";
        if(leftChild != null) result+= leftChild.postOrderTravers();
        if(rightChild != null) result += rightChild.postOrderTravers();
        result += this.data.toString()+ ",";
        return  result;
    }

    public TreeNode delete(Integer data){
       return null;
    }
}
