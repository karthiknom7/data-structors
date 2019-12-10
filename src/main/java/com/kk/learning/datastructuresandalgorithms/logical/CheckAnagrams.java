package com.kk.learning.datastructuresandalgorithms.logical;

public class CheckAnagrams {

//    O(n^2) can be changed the if we sort the input strings
    public boolean isAnagrams(String one, String two){
        if(one.length() != two.length()) return false;
        int length = one.length();
        for(int i =0 ; i < length ; i++){
            boolean found = false;
            int j = 0;
            while (j < length && !found){
                if (one.charAt(i) == two.charAt(j)){
                    found = true;
                }
                j++;
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}
