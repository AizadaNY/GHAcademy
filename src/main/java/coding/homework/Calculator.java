package coding.homework;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine().toLowerCase();
        String [] arrInput=input.split(" ");
        double result=0;
        double num1=Double.parseDouble(arrInput[1]);
        double num2=Double.parseDouble(arrInput[2]);
        String sign=arrInput[0].trim().toUpperCase();
//        System.out.println(sign);

        switch (sign){
            case "ADD":
                result=num1+num2;
                break;
            case "MUL":
                result=num1*num2;
                break;
            case "DIV":
                result=num1/num2;
                break;
            case "SUB":
                result=num1-num2;
                break;
            case "MOD":
                int div= ((int)num1/(int)num2);
                result=(int)num1-(div*num2);
                break;
            case "POW":
                double powResult=1;
                for (int i = 1; i <= num2; i++) {
                    powResult=powResult*num1;
                }
                result=powResult;
                break;
            default:
                System.out.println("No such option");
        }
        System.out.println("Result is "+result);




    }






}
