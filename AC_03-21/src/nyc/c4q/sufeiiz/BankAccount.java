package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/21/15.
 */
public class BankAccount {
    private String label;
    private int balance;

    public BankAccount(String label) {
        this.label = label;
        this.balance = 0;
    }

    public BankAccount(String label, int amount) {
        this.label = label;
        this.balance = amount;
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Not enough money in this account.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void printBalance() {
        System.out.println("Balance in account '" + label + "': " + balance);
    }
}
