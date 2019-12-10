package com.kk.learning.datastructuresandalgorithms.datastructures.array;

public class CustomArrayList<T> {

    private final int initialSize = 10;
    private Object data[] ;

    public CustomArrayList() {
        data = new Object[initialSize];
    }

    public CustomArrayList(T[] elements){
        int length = elements.length;
        data= new Object[length];
        for (int index=0; index< length; index++){
            data[index] = elements[index];
        }
    }

    public void add(int index, T element ){


    }

    public Object[] getAllElements(){
        return data;
    }


}
