package com.company.utils;

import java.io.*;

public class FileHelper {


    public void saveToFile(String content, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(content);
        writer.close();

    }

    public String readFromFile(String fileName) throws IOException {
        StringBuilder outputString = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                outputString.append(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputString.toString();
    }

}



