package de.tillmannheigel.adventofcode.AdventOfCode_2019_java.day_03_crossed_wires;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.tillmannheigel.adventofcode.AdventOfCode_2019_java.TestUtils;

class Day03Test {

    private Day03 day03 = new Day03();

    @Test
    void run_test01() throws IOException {
        List<List<String>> input = TestUtils.getCommaSeperatedLines("day03/test01");

        System.out.println(input);

        day03.solve(input);
    }

    @Test
    void run_test02() throws IOException {
        List<List<String>> input = TestUtils.getCommaSeperatedLines("day03/test02");

        System.out.println(input);

        day03.solve(input);
    }

    @Test
    void run_production() throws IOException {
        List<List<String>> input = TestUtils.getCommaSeperatedLines("day03/input");

        System.out.println(input);

        day03.solve(input);
    }

}