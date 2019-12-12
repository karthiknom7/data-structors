package com.kk.learning.datastructuresandalgorithms.datastructures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void shouldFindGivenDataNode() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        TreeNode treeNode = binarySearchTree.find(3);
        assertNotNull(treeNode);
        assertEquals(Integer.valueOf(3), treeNode.getData());
    }

    @Test
    public void inOrderTravers() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[1,2,3,4,5,6,7,]", inOrderTravers);
    }

    @Test
    public void preOrderTravers() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        String inOrderTravers = binarySearchTree.preOrderTravers();
        assertEquals("[4,2,1,3,6,5,7,]", inOrderTravers);
    }

    @Test
    public void postOrderTravers() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        String inOrderTravers = binarySearchTree.postOrderTravers();
        assertEquals("[1,3,2,5,7,6,4,]", inOrderTravers);
    }


}