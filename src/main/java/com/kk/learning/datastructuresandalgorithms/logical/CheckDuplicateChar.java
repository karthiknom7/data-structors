package com.kk.learning.datastructuresandalgorithms.logical;

public class CheckDuplicateChar {

    public boolean hasDuplicateChar(String input){

        for(int i =0; i < input.length() -1 ; i++){
            for(int j= i+1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
}
