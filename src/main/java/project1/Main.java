package project1;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CompressionExeption {
        String path="C:\\Users\\Aizada\\GH Academy Homework\\resources\\";
        String inputFile=path+"test.txt";
        String outputFile=path+"outputFile.sc";
        ReadFile.read(inputFile,outputFile);


    }

    @Test
    public void validateTextFile() throws IOException, CompressionExeption {
        String userDir=System.getProperty("user.dir")+File.separator+"resources";
        String filePath=userDir+File.separator+"test.txt";

        //read file
//        byte[] fileBeforeZip= ReadFile.readFileInListBytes(filePath);


//        String zippedFilePath=Compressor.compress(filePath,userDir+"Compressed.zip","compressedFile");
//        String unzippedFilePath=Decompressor.decompress(zippedFilePath,userDir);
//        byte[] fileAfterZip= ReadFile.readFileInListBytes(unzippedFilePath);
//        Assert.assertEquals(fileBeforeZip, fileAfterZip);

    }
}
