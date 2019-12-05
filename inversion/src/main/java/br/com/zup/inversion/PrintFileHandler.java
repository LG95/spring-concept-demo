package br.com.zup.inversion;

import java.util.Arrays;

public class PrintFileHandler implements FileHandler {
    @Override
    public void handleFileContent(String[] input) {
        Arrays.stream(input).forEach(System.out::println);
    }
}
