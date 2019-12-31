package com.kk.learning.datastructuresandalgorithms.logical.expression;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfixToPostFixConverterTest {

    private InfixToPostFixConverter infixToPostFixConverter = new InfixToPostFixConverter();
    @Test
    public void shouldConvertSimpleInfixExpressionToPostfix() {

        String postfix = infixToPostFixConverter.infixToPostfix("a+b");
        assertEquals("ab+", postfix);
    }

    @Test
    public void shouldConvertSimpleInfixExpressionToPostfix2() {

        String postfix = infixToPostFixConverter.infixToPostfix("a+b+c");
        assertEquals("abc++", postfix);
    }

    @Test
    public void shouldConvertSimpleInfixExpressionToPostfix3() {

        String postfix = infixToPostFixConverter.infixToPostfix("a+b*c");
        assertEquals("abc*+", postfix);
    }


    @Test
    public void shouldConvertSimpleInfixExpressionToPostfix4() {

        String postfix = infixToPostFixConverter.infixToPostfix("a+(b*c)");
        assertEquals("abc*+", postfix);
    }

}