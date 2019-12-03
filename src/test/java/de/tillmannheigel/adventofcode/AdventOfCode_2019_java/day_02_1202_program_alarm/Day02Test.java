package de.tillmannheigel.adventofcode.AdventOfCode_2019_java.day_02_1202_program_alarm;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.tillmannheigel.adventofcode.AdventOfCode_2019_java.TestUtils;

class Day02Test {

    private Day02 day02 = new Day02();

    @Test
    void run_test01() throws IOException {
        List<Integer> input = TestUtils.getCommaSeperatedInput("day02/test01");

        List<Integer> result = day02.solve(input);

        System.out.println(result);
    }

    @Test
    void run_test02() throws IOException {
        List<Integer> input = TestUtils.getCommaSeperatedInput("day02/test02");

        List<Integer> result = day02.solve(input);

        System.out.println(result);

    }

    @Test
    void run_test03() throws IOException {
        List<Integer> input = TestUtils.getCommaSeperatedInput("day02/test03");

        List<Integer> result = day02.solve(input);

        System.out.println(result);
    }

    @Test
    void run_input() throws IOException {
        List<Integer> input = TestUtils.getCommaSeperatedInput("day02/input");

        // fix input accordingly
        input.set(1, 12);
        input.set(2, 2);

        Integer result = day02.solve(input).get(0);

        System.out.println(result);
    }

}