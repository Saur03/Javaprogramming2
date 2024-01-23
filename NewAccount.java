package Javaprogramming2.Javaprogramming2;

import java.util.ArrayList;
import java.util.Date;

public class NewAccount {
    private String name;
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions;

    public NewAccount() {
    }

    public NewAccount(int id, double balance) {
        this.name =name;
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
        transactions = new ArrayList<Transaction>();
    }

    public NewAccount(String name, int id, double balance) {
        this(id, balance);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public  void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            transactions.add(new Transaction('W', amount, getBalance(), "Withdrawal"));
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        transactions.add(new Transaction('D', amount, getBalance(), "Deposit"));
        }
        else {
            System.out.println("Invalid deposit amount");
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
