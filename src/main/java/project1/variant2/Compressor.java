package project1.variant2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor {

    public static String  compress(String inputFilePath,String targetFilePath,String fileName) throws IOException {
        File f = new File(targetFilePath);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry(fileName);
        out.putNextEntry(e);
        byte[] data = ReadFile.readFileInListBytes(inputFilePath);

        out.write(data, 0, data.length);
        out.closeEntry();
        out.close();
        return targetFilePath;
    }
}
