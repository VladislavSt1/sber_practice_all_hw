package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NIOFileHandler implements FileHandler {
    @Override
    public void writeToFile(String fileName, String data) throws IOException {
        Files.write(Paths.get(fileName), data.getBytes());
    }

    @Override
    public String readFromFile(String fileName) throws IOException {
        byte[] encodedData = Files.readAllBytes(Paths.get(fileName));
        return new String(encodedData);
    }
}
