/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ninza
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TextModel {
    private String inputFilePath;
    private String outputFilePath;

    public TextModel(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public String normalizeText() throws IOException {
        StringBuilder normalizedText = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                  
                    line = line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase();
                    isFirstLine = false;
                }

                normalizedText.append(normalizeLine(line)).append("\n");
            }
        }

        if (normalizedText.length() > 0 && normalizedText.charAt(normalizedText.length() - 2) != '.') {
            normalizedText.append('.');
        }

        return normalizedText.toString();
    }

    private String normalizeLine(String line) {
    
    line = line.replaceAll("\\s+", " ");

    line = line.replaceAll(",\\s*", ", ");

    line = line.replaceAll("\\.\\s*", ". ");

   
    line = line.replaceAll(":\\s*", ": ");

    line = line.replaceAll("\"(.*?)\"", "$1");

    char[] chars = line.toCharArray();
    boolean capitalizeNext = true;
    for (int i = 0; i < chars.length; i++) {
        if (capitalizeNext && Character.isLetter(chars[i])) {
            chars[i] = Character.toUpperCase(chars[i]);
            capitalizeNext = false;
        } else if (chars[i] == '.') {
            capitalizeNext = true;
        }
    }
    return new String(chars);
    }

    public void Output(String normalizedText) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(normalizedText);
        }
    }
}
