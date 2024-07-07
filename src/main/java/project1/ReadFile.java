package project1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {


    /*
    P1"
    Easier version: A simple text compression algorithm -
    1. read input file (input.txt) +
    2. Identify all words in the text, assign a code to each
    3. Compress into output file (output.sc)
    4. Read compressed file and decompress.
    5. Write decompressed file into (readable.txt)
    6. Compare each byte of two files input.txt vs readable.txt
    Harder version: Implement Huffman compression
     */



    public static StringBuilder read(String filePath,String outputFile) throws  CompressionExeption {
        StringBuilder sb = new StringBuilder();
        try {

            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            ByteArrayOutputStream codeText = new ByteArrayOutputStream();
            Map<String, Short> wordToCode = new HashMap<String, Short>();
            Map<Short, String> codeToWord = new HashMap<Short, String>();
            String line = br.readLine();
            short newLine=0;
            wordToCode.put(System.lineSeparator(), newLine);
            codeToWord.put(newLine, System.lineSeparator());
            short codeCounter = (short) (newLine+1);
            int totalNumberOfWords=0;
            while (line != null) {
                String[] word = line.split("(?<=\\s)|(?=\\s)");
                for (String w : word) {
                    Short exCode = wordToCode.get(w);
                    if (exCode == null) {
                        wordToCode.put(w, codeCounter);
                        codeToWord.put(codeCounter, w);
                        byte high = (byte) (codeCounter >>> 8);
                        byte low = (byte) codeCounter;
                        codeText.write(high);
                        codeText.write(low);
                        totalNumberOfWords++;
                        codeCounter++;
                        if (codeCounter == Short.MAX_VALUE) {
                            throw new CompressionExeption("Too many words in the file");
                        }
                    }
                }
                codeText.write(0);
                codeText.write(0);
                totalNumberOfWords++;
                line = br.readLine();
            }

            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(outputFile));
            CompressionInfoHolder holder = new CompressionInfoHolder(codeToWord, codeText.toByteArray());
            writer.writeObject(holder);
            writer.flush();
            writer.close();
            System.out.println("Number of words " + codeCounter);
            System.out.println("Number of unique words " + totalNumberOfWords);

        } catch (FileNotFoundException exception) {
            System.out.println("Sorry file not found on the location: " + filePath);
        } catch (IOException e) {
            System.out.println("Sorry unexpected error occurred " + e);
        }


        return sb;
    }


}













