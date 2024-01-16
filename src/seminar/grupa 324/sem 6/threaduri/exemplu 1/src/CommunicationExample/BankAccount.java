package CommunicationExample;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public BankAccount() {
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount)
    {
        System.out.println("Current balance: " + balance);
        int temp = balance;
        temp += amount;
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance = temp;
        System.out.println("Balance after deposit: " + balance);
    }
}
