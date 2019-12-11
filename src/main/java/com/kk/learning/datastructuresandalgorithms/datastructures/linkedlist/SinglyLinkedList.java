package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

import java.util.ArrayList;

public class SinglyLinkedList {
    private Node head;

    public void insertAtHead(Integer data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        ArrayList l = new ArrayList();
        l.toString();
    }

    public void deleteAtHead(){
        if(isHeadPresent()) {
            Node current = head;
            head = head.getNext();
            current.setNext(head);
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
            current = current.getNext();
        }
        return length;
    }


    public Integer findElement(int element) {
        Node current = head;
        while (current != null){
            if(element == current.getData()){
                return element;
            }
            current = current.getNext();
        }
        return  null;
    }

    // Without considering the length variable of linked list
    public void appendLastNNodesToHeadWithoutLengthVariable(int n){

        Node current = head;
        boolean found = false;
        boolean invalidN = false;
        Node nextNode = null;
        while (!found && current.getNext() != null){
            nextNode = current;
            int fromCurrent = 0;
            while (fromCurrent < n && !invalidN ){
                nextNode = nextNode.getNext();
                fromCurrent++;
                if(nextNode == null){
                    invalidN = true;
                }
            }
            if(nextNode != null && nextNode.getNext() == null){
                found = true;
            }else {
                current = current.getNext();
            }
        }
        if (!invalidN){
        nextNode.setNext(head);
        Node newHead = current.getNext();
        current.setNext(null);
        head = newHead;
        }else {
            System.out.println(n + " is Greater than or equal to the length");
        }

    }

    // With the length variable of linked list
    public void appendLastNNodesToHead(int n){

        int length = length();
        if(length <= n) return;
        Node current = head;
        for (int index = 1 ; index < length - n; index++){
            current = current.getNext();
        }
        Node newHead = current.getNext();
        current.setNext(null);
        Node currentLast = newHead;
        while (currentLast.getNext() != null){
            currentLast = currentLast.getNext();
        }
        currentLast.setNext(head);
        head = newHead;

    }

    public void reverse(){

        Node previous = null;
        Node current = head;
        while (current != null){
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
            if(current == null){
                head = previous;
            }
        }
    }


    public void removeDuplicates(){

        Node current = head;
        while (current.getNext() != null){
            Node next = current;
            while (next.getNext() != null){
                if(next.getNext().getData() == current.getData()){
                    Node deleteNode = next.getNext();
                    next.setNext(deleteNode.getNext());
                    deleteNode.setNext(null);
                }else next = next.getNext();
            }
            current = current.getNext();
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
