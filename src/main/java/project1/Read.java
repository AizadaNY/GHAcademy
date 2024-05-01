package project1;

import java.io.File;
import java.io.IOException;

public class Read {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Aizada\\GH Academy Homework\\test.txt");
        InputFile.read(file);
    }
}
