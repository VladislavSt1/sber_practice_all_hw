package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class  IOFileHandlerTest {

    @Test
    public void testIOFile() throws IOException {
        String fileName = "test_io_file.txt";
        String data = "test data";

        FileHandler file = new IOFileHandler();
        file.writeToFile(fileName, data);

        String readData = file.readFromFile(fileName);
        Assertions.assertEquals(data, readData);
    }
}