package project1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class Decompressor {

    public static void decompress(String inputPath) throws IOException {
//        StringInputPath ="Declare The File Path Input";
        FileInputStream inputStream = new FileInputStream(inputPath);
        String outputPath = "Declare The File Path Output";
        FileOutputStream outputStream = new FileOutputStream(outputPath);
        InflaterInputStream decompresser = new InflaterInputStream(inputStream);
        int contents;
        while ((contents = decompresser.read()) != -1) {
            outputStream.write(contents);
        }
        outputStream.close();
        decompresser.close();
        System.out.println("File un-compressed today");
    }
}
