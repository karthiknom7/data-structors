package com.kk.learning.datastructuresandalgorithms.datastructures.tree;

import com.kk.learning.datastructuresandalgorithms.datastructures.tree.avl.AVLTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {
    @Test
    public void shouldInsertNodeAtRoot() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode( 3);
        assertEquals("[3,]", avlTree.inOrderTravers());
    }

    @Test
    public void shouldInsertNodeAtLeftOfRoot() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode( 3);
        avlTree.insertNode( 2);
        assertEquals("[2,3,]", avlTree.inOrderTravers());
    }

    @Test
    public void shouldInsertNodeAtRightOfRoot() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode( 3);
        avlTree.insertNode( 2);
        avlTree.insertNode( 4);
        assertEquals("[2,3,4,]", avlTree.inOrderTravers());
    }

    @Test
    public void shouldUpdatedHeightOfRoot() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode( 3);
        avlTree.insertNode( 2);
        avlTree.insertNode( 4);
        avlTree.insertNode( 1);
        assertEquals(2 , avlTree.getRoot().getHeight());
    }


    @Test
    public void shouldInsertNodesAndSolveLLProblem() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(3);
        avlTree.insertNode(2);
        avlTree.insertNode(1);
        assertEquals("[2,1,3,]", avlTree.preOrderTravers());
    }

    @Test
    public void shouldInsertNodesAndSolveLLProblemForMoreElements() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(8);
        avlTree.insertNode(7);
        avlTree.insertNode(9);
        avlTree.insertNode(6);
        avlTree.insertNode(5);
        assertEquals("[8,6,5,7,9,]", avlTree.preOrderTravers());
    }

    @Test
    public void shouldInsertNodesAndSolveLeftRightProblemForMoreElements() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(10);
        avlTree.insertNode(11);
        avlTree.insertNode(7);
        avlTree.insertNode(5);
        avlTree.insertNode(6);
        assertEquals("[10,6,5,7,11,]", avlTree.preOrderTravers());
    }

    @Test
    public void shouldInsertNodesAndSolveRightRightProblemForMoreElements() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(10);
        avlTree.insertNode(9);
        avlTree.insertNode(12);
        avlTree.insertNode(13);
        avlTree.insertNode(14);
        assertEquals("[10,9,13,12,14,]", avlTree.preOrderTravers());
    }

    @Test
    public void shouldInsertNodesAndSolveRightLeftProblemForMoreElements() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(10);
        avlTree.insertNode(9);
        avlTree.insertNode(14);
        avlTree.insertNode(16);
        avlTree.insertNode(15);
        assertEquals("[10,9,15,14,16,]", avlTree.preOrderTravers());
    }

}