package project1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {


        String text = "This is a test word for regex.";
        String regex = "(?<=\\s)|(?=\\s)";

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(text);
        String[] arr=text.split(regex);
        for (String s:arr) {
            System.out.println(s);
        }
        System.out.println();

//        while (matcher.find()) {
//            System.out.println("Found match at: " + matcher.start() + " to " + matcher.end());
//        }
    }
    }

