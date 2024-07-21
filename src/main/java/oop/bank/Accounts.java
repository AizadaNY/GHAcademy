package oop.bank;

public class Accounts implements Bank{
    @Override
    public long getBalance() {

    }

    @Override
    public void deposit(long sum) {
        getBalance()+sum;
    }

    @Override
    public void withdraw() {

    }
}
