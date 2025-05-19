package com.dorotamiler.codewars.kyu6;

import com.dorotamiler.codewars.kyu6.wholikesit.WhoLikesIt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhoLikesItTest {
    @Test
    public void testSolution1() {
        assertEquals("no one likes this", WhoLikesIt.solution1());
        assertEquals("Peter likes this", WhoLikesIt.solution1("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.solution1("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.solution1("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.solution1("Alex", "Jacob", "Mark", "Max"));
    }

    @Test
    public void testSolution2() {
        assertEquals("no one likes this", WhoLikesIt.solution2());
        assertEquals("Peter likes this", WhoLikesIt.solution2("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.solution2("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.solution2("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.solution2("Alex", "Jacob", "Mark", "Max"));
    }

    @Test
    public void testSolution3() {
        assertEquals("no one likes this", WhoLikesIt.solution3());
        assertEquals("Peter likes this", WhoLikesIt.solution3("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesIt.solution3("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesIt.solution3("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.solution3("Alex", "Jacob", "Mark", "Max"));
    }


    private static Stream<Arguments> checkTestCases() {
        return Stream.of(
                Arguments.of("no one likes this",new String []{}),
                Arguments.of("Peter likes this", new String []{"Peter"}),
                Arguments.of("Jacob and Alex like this", new String []{"Jacob", "Alex"}),
                Arguments.of("Max, John and Mark like this", new String []{"Max", "John", "Mark"}),
                Arguments.of("Alex, Jacob and 2 others like this", new String []{"Alex", "Jacob", "Mark", "Max"})
        );
    }

    @ParameterizedTest(name = "{index} => {0}")
    // or @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("checkTestCases")
    void testSolutions (String expectedResult, String [] inputNames){
        assertEquals(expectedResult, WhoLikesIt.solution1(inputNames));
        assertEquals(expectedResult, WhoLikesIt.solution2(inputNames));
        assertEquals(expectedResult, WhoLikesIt.solution3(inputNames));
    }
}
