package project1;

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

    }
}
