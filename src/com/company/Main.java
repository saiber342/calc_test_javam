package com.company;

import java.io.PrintStream;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        PrintStream out = System.out;

        Scanner sc = new Scanner(System.in);
        out.println("Input: ");
        try {
            out.println("Output: " + Calculator.calc(sc.nextLine()));
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
