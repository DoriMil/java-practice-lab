package com.dorotamiler.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniquePairs {

    public static void countUniquePairs() {

        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfPairs = scanner.nextInt();

            Set<Pair> uniquePairs = new HashSet<>();

            for (int i = 0; i < numberOfPairs; i++) {
                String first = scanner.next();
                String second = scanner.next();

                uniquePairs.add(new Pair(first, second));
                System.out.println(uniquePairs.size());
            }
        }
    }
}