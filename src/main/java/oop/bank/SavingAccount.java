package oop.bank;

public class SavingAccount implements Bank{

    String name;
    private String number;

    public SavingAccount(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
