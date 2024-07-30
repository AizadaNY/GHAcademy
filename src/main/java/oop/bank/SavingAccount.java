package oop.bank;

public class SavingAccount extends Accounts {

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


    public double withdraw(double amount) {
        if (balance > amount) {
            balance = balance - amount;
        } else {

        }
        return balance;
    }

    public double deposit(double amount) {
       return balance+amount;
    }



}
