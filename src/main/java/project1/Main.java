package project1;



import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String userDir=System.getProperty("user.dir");
        String filePath=userDir+ File.separator+"test.txt";
        //read file
        byte[] fileBeforeZip= ReadFile.readFileInListBytes(filePath);
        String zippedFilePath=Compressor.compress(filePath,userDir+"compressed.zip","compressedFile");
        String unzippedFilePath=Decompressor.decompress(zippedFilePath,userDir);
        byte[] fileAfterZip= ReadFile.readFileInListBytes(unzippedFilePath);
        Assert.assertEquals(fileAfterZip, fileAfterZip);



    }
}
