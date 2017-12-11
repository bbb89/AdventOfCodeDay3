package com.lukasz;

public class Solution {
    public static int findPath(int number) {
        int power = findOddPower(number);
        int longestPath = findLongestPossiblePath(power);
        int shortestPath = findShortestPossiblePath(longestPath);
        int path = calculatePath(power, number, longestPath, shortestPath);

        return path;
    }

    private static int findOddPower(int number) {
        while(Math.sqrt(number) % 1 != 0 || Math.sqrt(number) % 2 == 0) {
            number++;
        }

        return number;
    }

    private static int findLongestPossiblePath(int power) {
        return (int) Math.sqrt(power) - 1;
    }

    private static int findShortestPossiblePath(int longestPath) {
        return (longestPath + 1) / 2;
    }

    private static int calculatePath(int power, int number, int longestPath, int shortestPath) {
        int difference = longestPath - shortestPath;
        int counter = difference;
        boolean adding = false;

        for(int i = power; i != number; i--) {
            if(adding) {
                counter++;
            }else {
                counter--;
            }

            if (counter == difference || counter == 0) {
                adding = !adding;
            }
        }

        return shortestPath + counter;
    }
}
