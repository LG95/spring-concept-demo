package br.com.zup.inversion;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void readFileAsString(String filename, FileHandler fileHandler) {
        try (FileInputStream stream = new FileInputStream(filename)) {
            String input = new String(stream.readAllBytes());
            fileHandler.handleFileContent(input.split("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new NullPointerException();
        }
    }
}
