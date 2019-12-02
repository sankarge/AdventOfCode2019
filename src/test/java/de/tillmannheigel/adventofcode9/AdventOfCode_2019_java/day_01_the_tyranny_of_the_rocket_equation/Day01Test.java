package de.tillmannheigel.adventofcode9.AdventOfCode_2019_java.day_01_the_tyranny_of_the_rocket_equation;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = Day01.class)
class Day01Test {

    @Autowired
    private Day01 day01;

    @Test
    void run() throws IOException {
        long resultA = day01.solve_a();
        System.out.println("Result 1.a: " + resultA);

        long resultB = day01.solve_b();
        System.out.println("Result 1.b: " + resultB);
    }

}