package com.dorotamiler.utility;

public class StringCompressor {


    public static String compress(String input) {

        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            char previous = input.charAt(i - 1);
            if (current == previous) {
                count++;
            } else {
                compressed.append(previous).append(count);
                count = 1;
            }
        }

        compressed.append(input.charAt(input.length() - 1)).append(count);
        return compressed.toString();
    }
}
