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

    public static StringBuilder read(String filePath) throws IOException, CompressionExeption {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            ByteArrayOutputStream codeText=new ByteArrayOutputStream();
            Map<String, Short> wordToCode = new HashMap<String, Short>();
            Map<Short, String> codeToWord = new HashMap<Short,String>();
            String line = br.readLine();
            Short codeCounter = 0;
            while (line != null) {
                String[] word = line.split("(?<=\\s)|(?=\\s)");
                for (String w : word) {
                    Short exCode = wordToCode.get(w);
                    if (exCode == null) {
                        wordToCode.put(w, codeCounter);
                        codeToWord.put(codeCounter, w);
                        byte high=(byte)(codeCounter >>>8);
                        byte low=(byte)codeCounter;
                        codeText.write(high);
                        codeText.write(low);
                        codeCounter++;
                        if (codeCounter == Short.MAX_VALUE) {
                            throw new CompressionExeption("Too many words in the file");
                        }
                    }
                }
                line = br.readLine();
            }
            System.out.println("Number of words"+ codeCounter);

        } catch (FileNotFoundException exception) {
            System.out.println("Sorry file not found on the location: " + filePath);
        } catch (IOException e) {
            System.out.println("Sorry unexpected error occurred " + e);
        }
        return sb;
    }


}













