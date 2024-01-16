package ExamplePrimesFibonacci;

public class Prime implements Runnable {
    private int max;

    public Prime(int max) {
        this.max = max;
    }

    public boolean isPrime(int n)
    {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    @Override
    public void run() {
        int counter = 0;
        int n = 2;

        while (counter < max)
        {
            if (isPrime(n))
            {
                System.out.println(n + " is prime.");
                counter++;
            }
            n++;

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
