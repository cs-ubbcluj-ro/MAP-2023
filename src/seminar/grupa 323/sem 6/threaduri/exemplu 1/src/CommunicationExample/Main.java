package CommunicationExample;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(()->account.deposit(200));
        Thread t2 = new Thread(()->account.deposit(500));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
