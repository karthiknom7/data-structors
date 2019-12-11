package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

public class SortedLinkedList {

    private Node head;

    public void insert(int data){
        if(head == null)
            head = new Node(data);
        else if(data <= head.getData()){
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
        }
        else {
            Node current = head;
            while (current.getNext() != null && data >= current.getNext().getData()){
                current = current.getNext();
            }
            Node newNode = new Node(data);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder str = new StringBuilder( "[");
        Node current = head;
        while (current.getNext() != null) {
            str.append(current.getData()).append( ",");
            current = current.getNext();
        }
        str.append(current.getData()).append( "]");
        return str.toString();
    }
}
