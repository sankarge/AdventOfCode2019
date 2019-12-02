package de.tillmannheigel.adventofcode9.AdventOfCode_2019_java.day_01_the_tyranny_of_the_rocket_equation;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import de.tillmannheigel.adventofcode9.AdventOfCode_2019_java.AdventOfCode;

@Component
class Day01 extends AdventOfCode {

    long solve_a() throws IOException {
        return getFuel()
                .map(this::calculateFuel)
                .reduce(0L, Long::sum);
    }

    long solve_b() throws IOException {
        return getFuel()
                .map(this::calculateFuel)
                .map(this::addFuelForFuel)
                .reduce(0L, Long::sum);
    }

    private long addFuelForFuel(Long fuel) {
        return fuel + calcFuelForFUel(fuel);
    }

    private long calcFuelForFUel(final long fuel) {
        long calculatedFuel = calculateFuel(fuel);
        return calculatedFuel <= 0 ? 0 : calculatedFuel + calcFuelForFUel(calculatedFuel);
    }

    private long calculateFuel(final long weight) {
        return weight / 3L - 2L;
    }

    private Stream<Long> getFuel() throws IOException {
        return getInput("01").stream();
    }
}
