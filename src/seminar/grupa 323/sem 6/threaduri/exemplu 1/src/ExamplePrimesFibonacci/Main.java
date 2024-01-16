package ExamplePrimesFibonacci;

public class Main {
    public static void main(String[] args) {
        Thread primeThread = new Thread(new Prime(10), "ExamplePrimesFibonacci.Prime thread");
        Thread fibonacciThread = new Thread(new Fibonacci(10), "ExamplePrimesFibonacci.Fibonacci thread");

        primeThread.start();
        fibonacciThread.start();
        try {
            primeThread.join();
            fibonacciThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ExamplePrimesFibonacci.Main program finished!");
    }
}