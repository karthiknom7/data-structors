package com.kk.learning.datastructuresandalgorithms.datastructures.linkedlist;

public class DoublyLinkedList {
    private DNode head;

    public void insertAtEnd(int data){
        if(head == null) {
            head = new DNode(data);
        }else {
            DNode current = head;
            while (current.getNext() !=null){
                current = current.getNext();
            }
            DNode newNode = new DNode(data);
            current.setNext(newNode);
        }

    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder str = new StringBuilder( "[");
        DNode current = head;
        while (current.getNext() != null) {
            str.append(current.getData()).append( ",");
            current = current.getNext();
        }
        str.append(current.getData()).append( "]");
        return str.toString();
    }

    public void insertAtHead(int data) {
        if(head == null){
            head = new DNode(data);
        }else {
            DNode newNode = new DNode(data);
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
    }


    public void insertionSort(){

        DNode outer = head;
        while (outer.getNext() != null){
            DNode inner = outer.getNext();
            DNode current = outer;
            while (current.getPrevious() != null && current.getPrevious().getData() > inner.getData()){
                current = current.getPrevious();
            }
            if( current == head){
                if(inner.getNext() != null){
                    inner.getNext().setPrevious(inner.getPrevious());
                }
                inner.getPrevious().setNext(inner.getNext());
                current.setPrevious(inner);
                inner.setNext(current);
                inner.setPrevious(null);
                head = inner;
                outer = head.getNext();
            }else if (current != outer) {
                if(inner.getNext() != null){
                    inner.getNext().setPrevious(inner.getPrevious());
                }
                inner.getPrevious().setNext(inner.getNext());
                inner.setNext(current);
                inner.setPrevious(current.getPrevious());
                current.getPrevious().setNext(inner);
                current.setPrevious(inner);
                outer = outer.getNext();
            }else {
                outer = outer.getNext();
            }
        }
    }


}
