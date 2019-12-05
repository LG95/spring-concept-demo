package br.com.zup.inversion;

import java.util.Arrays;

public class SortFileLinesHandler implements FileHandler {
    @Override
    public void handleFileContent(String[] lines) {
        Arrays.sort(lines);
        Arrays.stream(lines).forEach(System.out::println);
    }
}
