package de.tillmannheigel.adventofcode.AdventOfCode_2019_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

    public static List<Long> getInputByLine(String path) throws IOException {

        ClassLoader classLoader = TestUtils.class.getClassLoader();
        URL url = classLoader.getResource(path);
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<Long> result = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.add(Long.valueOf(line));
        }
        return result;

    }

    public static List<Integer> getCommaSeperatedInput(String path) throws IOException {

        ClassLoader classLoader = TestUtils.class.getClassLoader();
        URL url = classLoader.getResource(path);
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<Integer> result = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            Arrays.stream(split).forEach(s -> result.add(Integer.valueOf(s)));
        }
        return result;

    }

    public static List<List<String>> getCommaSeperatedLines(String path) throws IOException {
        ClassLoader classLoader = TestUtils.class.getClassLoader();
        URL url = classLoader.getResource(path);
        InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<List<String>> result = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(",");
            result.add(Arrays.asList(split));
        }
        return result;

    }
}
