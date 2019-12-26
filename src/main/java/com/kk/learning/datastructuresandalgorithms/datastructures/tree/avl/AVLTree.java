package com.kk.learning.datastructuresandalgorithms.datastructures.tree.avl;

public class AVLTree {
    private AvlTreeNode root;

    public AvlTreeNode insertNode(Integer data) {
        root = insertNode(root, data);
        return root;
    }

    public AvlTreeNode getRoot() {
        return root;
    }

    private AvlTreeNode insertNode(AvlTreeNode currentNode, Integer data) {
        if (currentNode == null) {
            return new AvlTreeNode(data);
        } else if (currentNode.getData() < data) {
            AvlTreeNode right = insertNode(currentNode.getRightChild(), data);
            currentNode.setRightChild(right);
        } else {
            AvlTreeNode left = insertNode(currentNode.getLeftChild(), data);
            currentNode.setLeftChild(left);
        }
        calculateHeight(currentNode);
        return checkBalanceOfNode(currentNode, data);
    }

    private AvlTreeNode checkBalanceOfNode(AvlTreeNode currentNode, Integer data) {
        int balance = getBalance(currentNode);
        if (balance > 1) {
            if (data < currentNode.getLeftChild().getData()) {
                return rightRotate(currentNode);
            } else {
                return leftRightRotate(currentNode);
            }
        } else if (balance < -1) {
            if (data > currentNode.getRightChild().getData()) {
                return leftRotation(currentNode);
            } else {
                return rightLeftRotation(currentNode);
            }
        } else return currentNode;
    }

    private AvlTreeNode rightLeftRotation(AvlTreeNode currentNode) {
       AvlTreeNode right = currentNode.getRightChild();
       currentNode.setRightChild(right.getLeftChild());
       right.setLeftChild(null);
       currentNode.getRightChild().setRightChild(right);
       calculateHeight(right);
       calculateHeight(currentNode.getRightChild());

        return leftRotation(currentNode);
    }

    private AvlTreeNode leftRotation(AvlTreeNode currentNode) {
        AvlTreeNode newRoot = currentNode.getRightChild();
        newRoot.setLeftChild(currentNode);
        currentNode.setRightChild(null);
        calculateHeight(currentNode);
        calculateHeight(newRoot);
        return newRoot;

    }

    private AvlTreeNode leftRightRotate(AvlTreeNode currentNode) {
        AvlTreeNode left = currentNode.getLeftChild();
        currentNode.setLeftChild(left.getRightChild());
        currentNode.getLeftChild().setLeftChild(left);
        left.setRightChild(null);
        calculateHeight(left);
        calculateHeight(currentNode.getLeftChild());

        return rightRotate(currentNode);
    }

    private AvlTreeNode rightRotate(AvlTreeNode currentNode) {
        AvlTreeNode newRoot = currentNode.getLeftChild();
        currentNode.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(currentNode);
        calculateHeight(currentNode);
        calculateHeight(newRoot);
        return newRoot;
    }

    private int getBalance(AvlTreeNode currentNode) {
        int leftHeight = currentNode.getLeftChild() != null ? currentNode.getLeftChild().getHeight() : -1;
        int rightHeight = currentNode.getRightChild() != null ? currentNode.getRightChild().getHeight() : -1;
        return leftHeight - rightHeight;
    }

    private int getHeight(AvlTreeNode currentNode) {
        return currentNode != null ? currentNode.getHeight() : -1;
    }

    private void calculateHeight(AvlTreeNode currentNode) {
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            currentNode.setHeight(0);
        } else {
            int leftHeight = currentNode.getLeftChild() != null ? currentNode.getLeftChild().getHeight() : 0;
            int rightHeight = currentNode.getRightChild() != null ? currentNode.getRightChild().getHeight() : 0;
            currentNode.setHeight(Math.max(leftHeight, rightHeight) + 1);
        }
    }


    public String inOrderTravers() {
        if (root != null) return "[" + root.inOrderTravers() + "]";
        return "[]";
    }

    public String preOrderTravers() {
        if (root != null) return "[" + root.preOrderTravers() + "]";
        return "[]";
    }

    public String postOrderTravers() {
        if (root != null) return "[" + root.postOrderTravers() + "]";
        return "[]";
    }
}
