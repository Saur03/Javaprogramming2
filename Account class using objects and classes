// Program Name:- make an account class
// Purpose:- print the balance, the monthly interest and the date
// Author Name:- Saurabh Chawla
// Date:- 11 January 2024
package Javalabs;
import java.net.SocketOption;
import java.util.Date;
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {

    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
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

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount){
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
        }
        else {
            System.out.println("Invalid amount");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Invalid deposit amount");
        }
    }

    public static void main(String[] args) {
        Account a1 = new Account(1122, 2000);
        a1.setAnnualInterestRate(4.5);
        a1.withdraw(2500);
        a1.deposit(3000);
        System.out.println("The balance of my account is: $" + a1.getBalance());
        System.out.println("The Monthly Interest of my account is: $" + a1.getMonthlyInterest());
        System.out.println("The Date Created of my account is: " + a1.getDateCreated());

    }
}
