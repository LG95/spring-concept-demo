package br.com.zup.inversion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ControlNormal {
    public static void main(String[] args) {
        printFile();
        sortFileLines();
    }

    private static void printFile() {
        System.out.println(readFileAsString("README.md"));
    }

    private static void sortFileLines() {
        String input = readFileAsString("README.md");
        String[] lines = input.split("\n");
        Arrays.sort(lines);
        Arrays.stream(lines).forEach(System.out::println);
    }

    private static String readFileAsString(String filename) {
        try (FileInputStream stream = new FileInputStream(filename)) {
            return new String(stream.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
}
