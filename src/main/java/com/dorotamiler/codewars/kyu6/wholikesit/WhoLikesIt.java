package com.dorotamiler.codewars.kyu6.wholikesit;

public class WhoLikesIt {
    private WhoLikesIt() {
        // Private constructor to hide the implicit public one
    }

    /**
     * These methods method takes a variable number of names and returns a string indicating who likes something.
     * The output varies based on the number of names provided.
     *
     * @param names A variable number of names (String).
     * @return A string indicating who likes something.
     */

    public static String solution1(String... names) {
        if (names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";
        } else if (names.length == 2) {
            return names[0] + " and " + names[1] + " like this";
        } else if (names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else {
            return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        }
    }

    public static String solution2(String... names) {
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> names[0] + " likes this";
            case 2 -> names[0] + " and " + names[1] + " like this";
            case 3 -> names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default -> names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        };
    }

    public static String solution3(String... names) {
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> "%s likes this".formatted(names[0]);
            case 2 -> "%s and %s like this".formatted(names[0], names[1]);
            case 3 -> "%s, %s and %s like this".formatted(names[0], names[1], names[2]);
            default -> "%s, %s and %d others like this".formatted(names[0], names[1], names.length - 2);
        };
    }
}
