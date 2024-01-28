// Program Name:- make a Checking Account class
// Purpose:- make a checking account method and use of over draft limit
// Author Name:- Saurabh Chawla
// Date:- 11 January 2024
package Javalabs;

public class CheckingAccount extends Account{
    private double overdraftLimit;

    public CheckingAccount() {
        super();
        overdraftLimit = -20;
    }

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    // it checks if the account can handle the withdrawal without going beyond the allowed overdraft.
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Exceeds overdraft limit for CheckingAccount");
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "id=" + getId() +
                ", balance=" + getBalance() +
                ", annualInterestRate=" + getAnnualInterestRate() +
                ", dateCreated=" + getDateCreated() +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}

