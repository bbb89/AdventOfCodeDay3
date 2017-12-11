package com.lukasz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();

        System.out.println("Result is " + Solution.findPath(number));
        System.out.println("Result for part II is " + SolutionPart2.findFirstLargerThan(number));
    }
}
