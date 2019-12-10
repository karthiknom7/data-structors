package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

public class SortedLinkedList {

    private Node head;

    public void insert(int data){
        if(head == null)
            head = new Node(data);
        else if(data <= head.getData()){
            Node newNode = new Node(data);
            newNode.setNextNode(head);
            head = newNode;
        }
        else {
            Node current = head;
            while (current.getNextNode() != null && data >= current.getNextNode().getData()){
                current = current.getNextNode();
            }
            Node newNode = new Node(data);
            newNode.setNextNode(current.getNextNode());
            current.setNextNode(newNode);
        }

    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder str = new StringBuilder( "[");
        Node current = head;
        while (current.getNextNode() != null) {
            str.append(current.getData()).append( ",");
            current = current.getNextNode();
        }
        str.append(current.getData()).append( "]");
        return str.toString();
    }
}
