package project1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
 //check duplicate
     */

    public static byte[] readFileInListBytes(String filePath) {
        byte[] lines = new byte[0];
        try {
            lines = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }








    public static StringBuilder read(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        System.out.println(sb);
        return sb;
    }


    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(
                    Paths.get(fileName),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {

            // do something
            e.printStackTrace();
        }
        return lines;
    }




}
