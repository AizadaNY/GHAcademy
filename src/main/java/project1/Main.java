package project1;

import org.testng.Assert;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\Aizada\\GH Academy Homework\\test.txt";
//        StringBuilder data=InputFile.read(path);
//        System.out.println(data);
//        List<String> list1=InputFile.readFileInList(path);
//        System.out.println(list1);
        byte[] list2= ReadFile.readFileInListBytes(path);
        for (byte b:list2) {
            System.out.println(b);
        }

//        Compressor.compress2(path);
        String sourcePath="C:\\Users\\Aizada\\GH Academy Homework\\CompressedTest.zip";
//        String targetPath="C:\\Users\\Aizada\\GH Academy Homework\\DecompressedFile.txt";
//        String targetPath="C:\\Users\\Aizada\\GH Academy Homework";
//        Decompressor.unzip(sourcePath,targetPath);
        String path2="C:\\Users\\Aizada\\GH Academy Homework\\mytext.txt";
        byte[] list3= ReadFile.readFileInListBytes(path2);
        for (byte b:list3) {
            System.out.println(b);
        }


       Assert.assertEquals(list2, list3);


    }
}
