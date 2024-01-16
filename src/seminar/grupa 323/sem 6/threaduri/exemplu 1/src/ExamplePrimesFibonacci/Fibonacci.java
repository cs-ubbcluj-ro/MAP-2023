package ExamplePrimesFibonacci;

public class Fibonacci implements Runnable {
    private int max;

    public Fibonacci(int max) {
        this.max = max;
    }


    @Override
    public void run() {
        int counter = 0;
        int a = 0;
        int b = 1;

        while (counter < max)
        {
            int c = a + b;
            System.out.println("ExamplePrimesFibonacci.Fibonacci number: " + c);
            counter++;
            a = b;
            b = c;

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
