package com.kk.learning.datastructuresandalgorithms.logical.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class InfixToPostFixConverter {

    private List<Character> operators = Arrays.asList('+', '-', '*', '/', '(', ')');
    private char openBrace = '(';
    private char closedBrace = ')';

    String infixToPostfix(String infix) {
        char[] infixExp = infix.toCharArray();
        List<Character> postfixExp = new ArrayList<>(infixExp.length);
        Stack<Character> stack = new Stack<>();
        for (char eachStr : infixExp) {
            if (isOperator(eachStr)) {
                if (openBrace != eachStr && closedBrace != eachStr) {
                    stack.push(eachStr);
                }
            } else {
                postfixExp.add(eachStr);
            }
        }

        while (!stack.isEmpty()) {
            postfixExp.add(stack.pop());
        }

        return new String(toCharArray(postfixExp));
    }

    private boolean isOperator(char str) {
        return operators.contains(str);
    }

    private char[] toCharArray(List<Character> characters) {
        char[] charArray = new char[characters.size()];
        int index = 0;
        for (char c : characters) {
            charArray[index++] = c;
        }
        return charArray;
    }
}
