package project1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public interface InputFile {
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

    public static String read(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader br=new BufferedReader(new FileReader(file));
        String line;
        while ((line= br.readLine())!=null){
              System.out.println(line);

        }
        br.close();
        return line;
    }

    public static void compress(String filePath ){
        try {
            File file = new File(filePath);
            String zipFileName = file.getName().concat(".zip");
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            zos.putNextEntry(new ZipEntry(file.getName()));
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            zos.write(bytes, 0, bytes.length);
            zos.closeEntry();
            zos.close();
        } catch (FileNotFoundException ex) {
            System.err.format("The file %s does not exist", filePath);
        } catch (IOException ex) {
            System.err.println("I/O error: " + ex);
        }
    }

    public static void decompress(String inputPath ) throws IOException {
//        StringinputPath ="Declare The File Path Input";
        FileInputStream inputStream = new FileInputStream(inputPath);
        String outputpath = "Declare The File Path Output";
        FileOutputStream outputStream = new FileOutputStream(outputpath);
        InflaterInputStream decompresser = new InflaterInputStream(inputStream);
        int contents;
        while ((contents=decompresser.read())!=-1){
            outputStream.write(contents);
        }
        outputStream.close();
        decompresser.close();
        System.out.println("File un-compressed today");
    }

}
