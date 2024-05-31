package coding.homework;


import java.util.Locale;
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
        System.out.println(sign);
        System.out.println(num1);
        System.out.println(num2);
        switch (sign){
            case "ADD":
                result=num1+num2;

            case "MUL":
                result=num1*num2;
            case "DIV":
                result=num1/num2;
            case "SUB":
                result=num1-num2;
            case "MOD":
                Math.round(num1);
                Math.round(num2);
                int div= (int) (num1/num2);
                result=num1-(div*num2);

            case "POW":
                double powResult=1;
                for (int i = 1; i < num2; i++) {
                    powResult=powResult*num1;
                }
                result=powResult;
        }
        System.out.println("Result is "+result);




    }


}
