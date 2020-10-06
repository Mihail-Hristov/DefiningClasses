package bank.account;

public class BankAccount {

    private static int currentID = 0;
    private final static double DEFAULT_INTEREST_RATE = 0.02;

    private double balance;
    private int id;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public BankAccount() {
        this.id = ++currentID;
        this.balance  = 0;
    }

    public int getId() {
        return this.id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return  this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }
}
