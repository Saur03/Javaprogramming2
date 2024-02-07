// Program Name:- make a Saving Account class
// Purpose:- make a saving account and make withdraw method also
// Author Name:- Saurabh Chawla
// Date:- 11 January 2024
package Javalabs;

public class SavingAccount extends Account {

    public SavingAccount() {
    }

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }
    // it checks  if there are sufficient funds to cover the withdrawal
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot overdraw from SavingsAccount");
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id=" + getId() +
                ", balance=" + getBalance() +
                ", annualInterestRate=" + getAnnualInterestRate() +
                ", dateCreated=" + getDateCreated() +
                '}';
    }
}