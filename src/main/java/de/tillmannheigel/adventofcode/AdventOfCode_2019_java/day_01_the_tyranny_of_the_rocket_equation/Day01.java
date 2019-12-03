package de.tillmannheigel.adventofcode.AdventOfCode_2019_java.day_01_the_tyranny_of_the_rocket_equation;

import java.util.List;

class Day01 {

    long solve_a(List<Long> fuel) {
        return fuel.stream()
                .map(this::calculateFuel)
                .reduce(0L, Long::sum);
    }

    long solve_b(List<Long> fuel) {
        return fuel.stream()
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

}
