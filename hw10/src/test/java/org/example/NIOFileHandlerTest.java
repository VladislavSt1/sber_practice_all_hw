package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class NIOFileHandlerTest {
    @Test
    public void testNIOFile() throws IOException {
        String fileName = "test_nio_file.txt";
        String data = "test data";

        FileHandler file = new NIOFileHandler();
        file.writeToFile(fileName, data);

        String readData = file.readFromFile(fileName);
        Assertions.assertEquals(data, readData);
    }
}