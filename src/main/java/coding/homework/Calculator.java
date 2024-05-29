package coding.homework;


import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String [] arrInput=input.split(" ");
        double result=0;
        double num1=Double.parseDouble(arrInput[1]);
        double num2=Double.parseDouble(arrInput[2]);
        switch (arrInput[0]){
            case "ADD":
                result=num1+num2;
            case "MUL":
                result=num1*num2;
            case "DIV":
                result=num1/num2;
            case "SUB":
                result=num1-num2;
            case "MOD":
                result=num1/num2;

            case "POW":
                for (int i = 1; i < num2; i++) {

                }
        }
        System.out.println("Result is: "+result);



    }

    public double power(int a,int b){

        while (b>1){
           int result=a;
        }

    }
}
