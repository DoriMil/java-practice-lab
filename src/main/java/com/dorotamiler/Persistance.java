package com.dorotamiler;

public class Persistance {

    public static int persistence(long n) {
        int numberOfSteps = 0;

        while (n >= 10) {

            long result = 1;
            String numberAsString = Long.toString(n);

            for (int i = 0; i < numberAsString.length(); i++) {
                int digit = Character.getNumericValue((numberAsString.charAt(i));
                result = result * digit;
            }
            n = result;
            numberOfSteps++;
        }
        return numberOfSteps;
    }
}