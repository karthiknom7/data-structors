package com.kk.learning.datastructuresandalgorithms.datastructures.tree;

import com.kk.learning.datastructuresandalgorithms.datastructures.tree.avl.AVLTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {

    @Test
    public void shouldInsertNodesAndSolveLLProblem() {
        AVLTree avlTree = new AVLTree();
        avlTree.insertNode(3);
        avlTree.insertNode(2);
        avlTree.insertNode(1);
        assertEquals("[2,1,3,]", avlTree.preOrderTravers());
    }
}