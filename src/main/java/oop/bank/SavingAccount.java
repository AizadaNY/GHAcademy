package oop.bank;

public class SavingAccount implements Bank {

    String name;
    private String number;
    private double balance;

    public SavingAccount(String name, String number, double balance) {
        this.name = name;
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }

    public double deposit(double sum) {
       return getBalance()+sum;
    }



}
