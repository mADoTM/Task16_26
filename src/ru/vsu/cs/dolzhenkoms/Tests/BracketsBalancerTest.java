package ru.vsu.cs.dolzhenkoms.Tests;

import org.junit.Assert;
import ru.vsu.cs.dolzhenkoms.BracketsBalancer;

class BracketsBalancerTest {

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingDefaultStackEmptyString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("", false);
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingDefaultStackSimplyString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("()", false);
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingDefaultStackDefaultNotBalancedString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("[{]}", false);
        Assert.assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingDefaultStackDefaultBalancedString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("((()){})", false);
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingCustomStackEmptyString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("", true);
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingCustomStackSimplyString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("()", true);
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingCustomStackDefaultNotBalancedString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("[{]}", true);
        Assert.assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingStackUsingCustomStackDefaultBalancedString() {
        boolean result = BracketsBalancer.isStringBalancedUsingStack("((()){})", true);
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingRecursiveEmptyString() {
        boolean result = BracketsBalancer.isStringBalancedUsingRecursive("");
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingRecursiveSimplyString() {
        boolean result = BracketsBalancer.isStringBalancedUsingRecursive("()");
        Assert.assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingRecursiveNotBalancedString() {
        boolean result = BracketsBalancer.isStringBalancedUsingRecursive("[{]}");
        Assert.assertFalse(result);
    }

    @org.junit.jupiter.api.Test
    void isStringBalancedUsingRecursiveDefaultBalancedString() {
        boolean result = BracketsBalancer.isStringBalancedUsingRecursive("((()){})");
        Assert.assertTrue(result);
    }
}