package de.tillmannheigel.adventofcode9.AdventOfCode_2019_java.day_01_the_tyranny_of_the_rocket_equation;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import de.tillmannheigel.adventofcode9.AdventOfCode_2019_java.AdventOfCode;

@Component
class Day01 extends AdventOfCode {

    long solve_a() throws IOException {
        return getFuel()
                .reduce(0L, Long::sum);
    }

    long solve_b() throws IOException {
        return getFuel()
                .map(this::calcFuelForFuel)
                .reduce(0L, Long::sum);
    }

    private Stream<Long> getFuel() throws IOException {
        return getNumbers("01").stream()
                .map(this::calculateFuel);
    }

    private long calcFuelForFuel(Long fuel) {
        return fuel + getFuelForFuel(fuel);
    }

    private long getFuelForFuel(final long fuel) {
        long calculatedFuel = calculateFuel(fuel);
        return calculatedFuel <= 0 ? 0 : calculatedFuel + getFuelForFuel(calculatedFuel);
    }

    private long calculateFuel(final long weight) {
        return weight / 3L - 2L;
    }
}
