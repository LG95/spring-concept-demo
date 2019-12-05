package br.com.zup.inversion;

public class InvertedControl {
    public static void main(String[] args) {
        ReadFile.readFileAsString("README.md", new PrintFileHandler());
        ReadFile.readFileAsString("README.md", new SortFileLinesHandler());
    }
}
