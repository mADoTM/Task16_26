package ru.vsu.cs.dolzhenkoms;

import ru.vsu.cs.dolzhenkoms.CustomStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketsBalancer {
    private final static Map<Character, Character> bracketsDictionary = new HashMap<>() {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    private final static Map<Character, Character> reverseBracketsDictionary = new HashMap<>() {{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    private final static Map<Character, Integer> bracketsCounter = new HashMap<>() {{
        put('(', 0);
        put('{', 0);
        put('[', 0);
    }};

    private static int lastOpeningBracketIndex = -1;

    public static boolean isStringBalancedUsingStack(String str, boolean usingCustomStack) {
        if (str.length() == 1) return false;

        Stack<Character> defaultStack = usingCustomStack ? new CustomStack<>() : new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);

            if(bracketsDictionary.containsKey(symbol))
                defaultStack.push(symbol);

            if(bracketsDictionary.containsValue(symbol)) {
                if(defaultStack.empty())
                    return false;

                char lastOpeningBrackets = defaultStack.pop();
                if(bracketsDictionary.get(lastOpeningBrackets) != symbol)
                    return false;
            }
        }

        return defaultStack.empty();
    }

    public static boolean isStringBalancedUsingRecursive(String str) {
        return checkRecursiveStringBalanced(str, 0);
    }

    private static boolean checkRecursiveStringBalanced(String str, int index) {
        if(str.length() == 1)
            return false;
        if(index < str.length()) {
            char symbol = str.charAt(index);

            if(bracketsDictionary.containsKey(symbol)) {
                bracketsCounter.put(symbol, bracketsCounter.get(symbol) + 1);

                lastOpeningBracketIndex = index;
            }

            if(reverseBracketsDictionary.containsKey(symbol)) {
                int counter = bracketsCounter.get(reverseBracketsDictionary.get(symbol));

                if(counter == 0 || str.charAt(lastOpeningBracketIndex) != reverseBracketsDictionary.get(symbol))
                    return false;

                bracketsCounter.put(symbol, counter - 1);
                String newWord = getStringWithout2Symbols(str, lastOpeningBracketIndex, index);
                return checkRecursiveStringBalanced(newWord, 0);
            }

            return checkRecursiveStringBalanced(str, index + 1);
        }
        return true;
    }

    private static String getStringWithout2Symbols(String str, int index1, int index2) {
        char[] chars = new char[str.length() - 2];

        if(index1 > index2) {
            int temp = index2;
            index2 = index1;
            index1 = temp;
        }

        for(int i = 0; i < str.length(); i++) {
            if(i < index1) {
                chars[i] = str.charAt(i);
            }
            if(i > index1 && i < index2) {
                chars[i - 1] = str.charAt(i);
            }
            if(i > index2) {
                chars[i - 2] = str.charAt(i);
            }
        }

        return String.valueOf(chars);
    }
}
