package project1;

import java.io.*;

public interface InputFile {
    /*
    P1
    Easier version: A simple text compression algorithm -
    1. read input file (input.txt)
    2. Identify all words in the text, assign a code to each
    3. Compress into output file (output.sc)
    4. Read compressed file and decompress.
    5. Write decompressed file into (readable.txt)
    6. Compare each byte of two files input.txt vs readable.txt
    Harder version: Implement Huffman compression

     */

    public static void read(File file) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line;
        while ((line= br.readLine())!=null){
              System.out.println(line);
        }
    }
}
