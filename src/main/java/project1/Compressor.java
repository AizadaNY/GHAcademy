package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor {

    public static void compress2(String filePath) throws IOException {

        File f = new File("C:\\Users\\Aizada\\GH Academy Homework\\CompressedTest.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry("mytext.txt");
        out.putNextEntry(e);

        byte[] data = ReadFile.readFileInListBytes(filePath);
        out.write(data, 0, data.length);
        out.closeEntry();

        out.close();
    }
}
