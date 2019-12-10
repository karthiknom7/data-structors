package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

import java.util.ArrayList;

public class SinglyLinkedList {
    private Node head;

    public void insertAtHead(Integer data){
        Node newNode = new Node(data);
        newNode.setNextNode(head);
        head = newNode;
        ArrayList l = new ArrayList();
        l.toString();
    }

    public void deleteAtHead(){
        if(isHeadPresent()) {
            Node current = head;
            head = head.getNextNode();
            current.setNextNode(head);
        }
    }


    private boolean isHeadPresent(){
        return head != null;
    }

    public int length(){
        int length = 0;
        if (!isHeadPresent()) return length;
        Node current = head;
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }


    public Integer findElement(int element) {
        Node current = head;
        while (current != null){
            if(element == current.getData()){
                return element;
            }
            current = current.getNextNode();
        }
        return  null;
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
