package com.kk.learning.datastructuresandalgorithms.logical.array;


public class EncodeString {

    public static String collapseString(String inputString) {
        System.out.println(inputString);
        if(inputString.isEmpty()) return inputString;
        int currentCharCount =1;
        String encodedString = "";
        char[] chars = inputString.toCharArray();
        for(int i=0; i < chars.length-1; i++){
            if(chars[i] != chars[i+1]){
                encodedString+= currentCharCount + "" + chars[i];
                currentCharCount =1;
            }else {
                currentCharCount+=1;
            }
        }
        encodedString+= currentCharCount + "" + chars[chars.length-1];
        return encodedString;
    }
}
