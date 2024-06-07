package project1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public interface ReadFile {
    /*
    P1
    Easier version: A simple text compression algorithm -
    1. read input file (input.txt) +
    2. Identify all words in the text, assign a code to each
    3. Compress into output file (output.sc)
    4. Read compressed file and decompress.
    5. Write decompressed file into (readable.txt)
    6. Compare each byte of two files input.txt vs readable.txt
    Harder version: Implement Huffman compression
     */

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

    public static StringBuilder read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            Map<String,Short> wordToCode=new HashMap<String,Short>();
            String line = "";

            while (line != null) {
                line=br.readLine();
                String[] word=line.split("(?<=\\s)|(?=\\s)");
            }
            br.close();
            System.out.println(sb);
            return sb;
        } catch (FileNotFoundException exception) {
            System.out.println("Sorry file not found on the location: " + filePath);
        } catch (IOException e) {
            System.out.println("Sorry unexpected error occurred " + e);
        }
        return sb;
    }


}













