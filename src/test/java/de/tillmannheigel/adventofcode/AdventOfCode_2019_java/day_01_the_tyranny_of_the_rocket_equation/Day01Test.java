package de.tillmannheigel.adventofcode.AdventOfCode_2019_java.day_01_the_tyranny_of_the_rocket_equation;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.tillmannheigel.adventofcode.AdventOfCode_2019_java.TestUtils;

class Day01Test {

    private Day01 day01 = new Day01();

    @Test
    void run() throws IOException {

        List<Long> input = TestUtils.getInputByLine("day01/input");

        long resultA = day01.solve_a(input);
        System.out.println("Result 1.a: " + resultA);

        long resultB = day01.solve_b(input);
        System.out.println("Result 1.b: " + resultB);
    }

}