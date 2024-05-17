package project1;
import java.io.*;
import java.util.zip.*;

public class Decompressor {


    public static String  decompress(String zipFile, String destFolder) throws IOException {
        String path="";
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            byte[] buffer = new byte[1024];
            while ((entry = zis.getNextEntry()) != null) {
               path=destFolder + File.separator + entry.getName();
               System.out.println("Unzipped file path "+path);
                File newFile = new File(path);
                if (entry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    new File(newFile.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
            }
        }
        return path;
    }
}


