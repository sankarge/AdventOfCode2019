package de.tillmannheigel.adventofcode.AdventOfCode_2019_java.day_03_crossed_wires;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

public class Day03 {

    public void solve(List<List<String>> input) {
        List<List<DirectionDistanceCommand>> parsedCommands = input.parallelStream()
                .map(strings -> strings.stream()
                        .map(DirectionDistanceCommand::fromInput)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<List<Point>> traces = parsedCommands.stream()
                .map(directionDistanceCommands -> trace(new Point(0, 0), directionDistanceCommands))
                .collect(Collectors.toList());

        List<Point> firstTrace = traces.get(0);
        List<Point> secondTrace = traces.get(1);

        Optional<Integer> result = firstTrace.stream()
                .filter(secondTrace::contains)
                .map(point -> Math.abs(point.getX()) + Math.abs(point.getY()))
                .sorted()
                .findFirst();

        System.out.println(result.get());
    }

    private List<Point> trace(final Point startingPoint, final List<DirectionDistanceCommand> directionDistanceCommands) {
        if (directionDistanceCommands.isEmpty()) {
            return Collections.emptyList();
        }

        List<DirectionDistanceCommand> restCommands = directionDistanceCommands.subList(1, directionDistanceCommands.size());
        DirectionDistanceCommand command = directionDistanceCommands.get(0);
        LinkedList<Point> result = createLine(startingPoint, command);

        result.addAll(trace(result.getLast(), restCommands));
        return result;
    }

    private LinkedList<Point> createLine(final Point startingPoint, final DirectionDistanceCommand command) {

        switch (command.getDirection()) {
            case 'R':
                return markX(startingPoint, command.getDistance(), true);
            case 'L':
                return markX(startingPoint, command.getDistance(), false);
            case 'U':
                return markY(startingPoint, command.getDistance(), true);
            case 'D':
                return markY(startingPoint, command.getDistance(), false);
        }

        return null;
    }

    private LinkedList<Point> markY(final Point startingPoint, final int distance, final boolean positive) {
        LinkedList<Point> points = new LinkedList<>();
        for (int i = 1; i <= distance; i++) {
            if (positive) {
                points.add(new Point(startingPoint.getX(), startingPoint.getY() + i));
            } else {
                points.add(new Point(startingPoint.getX(), startingPoint.getY() - i));
            }
        }
        return points;
    }

    private LinkedList<Point> markX(final Point startingPoint, final int distance, final boolean positive) {
        LinkedList<Point> points = new LinkedList<>();
        for (int i = 1; i <= distance; i++) {
            if (positive) {
                points.add(new Point(startingPoint.getX() + i, startingPoint.getY()));
            } else {
                points.add(new Point(startingPoint.getX() - i, startingPoint.getY()));
            }
        }
        return points;
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static class DirectionDistanceCommand {
        char direction;
        int distance;

        static DirectionDistanceCommand fromInput(String directionDistanceCommand) {
            char direction = directionDistanceCommand.charAt(0);
            int distance = Integer.parseInt(directionDistanceCommand.substring(1));
            return new DirectionDistanceCommand(direction, distance);
        }
    }

    @AllArgsConstructor
    @Getter
    @ToString
    @EqualsAndHashCode
    private static class Point {
        int x;
        int y;
    }
}
