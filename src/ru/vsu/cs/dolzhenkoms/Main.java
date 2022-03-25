package ru.vsu.cs.dolzhenkoms;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(BracketsBalancer.isStringBalancedUsingStack("(()", true));
        String str = readString();

        boolean isRecursive = readAnswer(true);
        boolean result;

        if(isRecursive) {
            result = BracketsBalancer.isStringBalancedUsingRecursive(str);
        } else {
            boolean usingCustomStack = readAnswer(false);
            result = BracketsBalancer.isStringBalancedUsingStack(str, usingCustomStack);
        }

        System.out.println("Your string is " + (result ? "balanced" : "not balanced"));

    }

    private static String readString() {
        System.out.println("Enter string - ");

        Scanner scn = new Scanner(System.in);

        return scn.next();
    }

    private static boolean readAnswer(boolean isRecursiveAnswer) {
        if(isRecursiveAnswer)
            System.out.println("Do you want to use recursive algorithm? Enter answer [TRUE/FALSE] - ");
        else
            System.out.println("Do you want to use custom stack? Enter answer [TRUE/FALSE] - ");

        Scanner scn = new Scanner(System.in);

        boolean input = true;

        try {
            input = scn.nextBoolean();
        }
        catch (Exception ex) {
            System.out.println("You've entered the wrong data. Retry...");
            return readAnswer(isRecursiveAnswer);
        }

        return input;
    }
}
