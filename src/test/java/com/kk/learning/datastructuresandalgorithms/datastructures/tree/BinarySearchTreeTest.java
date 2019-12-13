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
    public void shouldDeletLeafNode() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
     binarySearchTree.deleteNode(3);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[1,2,4,5,6,7,]", inOrderTravers);
    }


    @Test
    public void shouldDeleteNodeWhichHasBothTheChildren() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        binarySearchTree.insertNode(7);

        binarySearchTree.deleteNode(6);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[1,2,3,4,5,7,7,]", inOrderTravers);
    }

    @Test
    public void shouldDeleteNodeWhichHasOnlyRightChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        binarySearchTree.insertNode(7);

        binarySearchTree.deleteNode(7);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[1,2,3,4,5,6,7,]", inOrderTravers);
    }

    @Test
    public void shouldDeleteNodeWhichHasOnlyLeftChild() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        binarySearchTree.insertNode(7);
        binarySearchTree.insertNode(0);

        binarySearchTree.deleteNode(1);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[0,2,3,4,5,6,7,7,]", inOrderTravers);
    }

    @Test
    public void shouldDeleteNodeAtRoot() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        binarySearchTree.insertNode(7);

        binarySearchTree.deleteNode(4);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[1,2,3,5,6,7,7,]", inOrderTravers);
    }

    @Test
    public void shouldDeleteRootNodeIfThereIsOnlyOneNode() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.deleteNode(4);
        String inOrderTravers = binarySearchTree.inOrderTravers();
        assertEquals("[]", inOrderTravers);
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

    @Test
    public void shouldCountLeafNodes() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        int leafNodes = binarySearchTree.countLeafNodes();
        assertEquals(4, leafNodes);
    }

    @Test
    public void shouldFindHeightOfTree(){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(6);
        binarySearchTree.insertNode(2);
        binarySearchTree.insertNode(3);
        binarySearchTree.insertNode(1);
        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(7);
        int heightOfTree = binarySearchTree.heightOfTree();
        assertEquals(3, heightOfTree);

        binarySearchTree.insertNode(7);
        heightOfTree = binarySearchTree.heightOfTree();
        assertEquals(4, heightOfTree);
    }
}