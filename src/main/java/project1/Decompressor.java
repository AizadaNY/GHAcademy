package project1;
import java.io.*;
import java.util.zip.*;

public class Decompressor {




    public static void main(String[] args) throws IOException, ClassNotFoundException, CompressionExeption {
        String path="C:\\Users\\Aizada\\GH Academy Homework\\resources\\";
        String outputFile=path+"outputFile.sc";

        String compressedFile = outputFile;
        String decompressedFile = outputFile+".txt";
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(compressedFile));
        Object inputObject=inputStream.readObject();
        if(!(inputObject instanceof CompressionInfoHolder)){

            throw  new CompressionExeption("Unexpected type received"+CompressionInfoHolder.class.getCanonicalName());
        }
        CompressionInfoHolder infoHolder=(CompressionInfoHolder) inputObject;

        BufferedWriter decompressedWriter=new BufferedWriter(new FileWriter(decompressedFile));
        byte[] codedByte=infoHolder.getCodeText();
        for (int i = 0; i < codedByte.length; i+=2) {
            short high=codedByte[i];
            short low=codedByte[i+1];
            short code=(short) ((high<<8)+low);

            String word=infoHolder.getCodeToWord().get(code);
            if(word!=null){
                decompressedWriter.write(word);
            }
        }
        decompressedWriter.flush();
        decompressedWriter.close();

        System.out.println("Compressed file has "+ codedByte.length/2+ " words");
        System.out.println("Compressed file has "+ infoHolder.getCodeToWord().size() + " unique words");
    }
}


