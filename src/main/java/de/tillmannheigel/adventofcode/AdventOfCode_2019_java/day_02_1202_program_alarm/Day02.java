package de.tillmannheigel.adventofcode.AdventOfCode_2019_java.day_02_1202_program_alarm;

import java.util.List;

public class Day02 {

    public List<Integer> solve(List<Integer> input) {
        return proceed(input, 0);
    }

    private List<Integer> proceed(final List<Integer> input, final int offset) {

        if (offset + 3 > input.size()) {
            return input;
        }

        // get input opCode
        Integer opCode = input.get(offset);
        Integer firstPosition = input.get(1 + offset);
        Integer secondPosition = input.get(2 + offset);
        Integer resultPosition = input.get(3 + offset);

        // decide what to do
        switch (opCode) {
            case 1:
                input.set(resultPosition, input.get(firstPosition) + input.get(secondPosition));
                break;
            case 2:
                input.set(resultPosition, input.get(firstPosition) * input.get(secondPosition));
                break;
            case 99:
                return input;
            default:
                throw new IllegalStateException(String.format("Something went wrong. Opcode: %s", opCode));
        }
        return proceed(input, offset + 4);
    }

}
