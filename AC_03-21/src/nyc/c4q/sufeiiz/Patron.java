package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/21/15.
 */

public class Patron {
    private String name;
    private int pocket;
    private BankAccount[] accounts;

    public Patron(String name, BankAccount account) {
        this.name = name;
        this.pocket = 0;
        this.accounts = new BankAccount[]{account};
    }

    public Patron(String name, int pocket, BankAccount account) {
        this.name = name;
        this.pocket = pocket;
        this.accounts = new BankAccount[]{account};
    }

    public Patron(String name, BankAccount[] accounts) {
        this.name = name;
        this.pocket = 0;
        this.accounts = accounts;
    }

    public Patron(String name, int pocket, BankAccount[] accounts) {
        this.name = name;
        this.pocket = pocket;
        this.accounts = accounts;
    }

    public void getMoney(int amount) {
        if (accounts[0].withdraw(amount))
            this.pocket += amount;
    }

    public void getMoney(int amount, int accountID) {
        if (accounts[accountID].withdraw(amount))
            this.pocket += amount;
    }

    public void putMoney(int amount) {
        if (amount > pocket) {
            System.out.println("Not enough money in " + name + "'s pocket.");
        } else {
            this.pocket -= amount;
            accounts[0].deposit(amount);
        }
    }

    public void putMoney(int amount, int accountID) {
        if (amount > pocket) {
            System.out.println("Not enough money in " + name + "'s pocket.");
        } else {
            this.pocket -= amount;
            accounts[accountID].deposit(amount);
        }
    }

    public void printPocket() {
        System.out.println(name + "'s pocket: " + pocket);
    }
}
