package oop.bank;

public class CheckingAccount implements Bank {
     String name;
     private String number;

    public CheckingAccount(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public void getBalance() {

    }

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }
}
