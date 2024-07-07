package project1.variant2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    public static byte[] readFileInListBytes(String filePath) {
        byte[] lines = new byte[0];
        try {
            lines = Files.readAllBytes(Paths.get(filePath));
        } catch (FileNotFoundException exception) {
            System.out.println("Sorry file not found on the location: " + filePath);
        } catch (IOException e) {
            System.out.println("Sorry unexpected error occurred " + e);
        }
        return lines;
    }
}
