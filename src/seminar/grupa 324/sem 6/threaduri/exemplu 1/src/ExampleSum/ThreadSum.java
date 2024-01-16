package ExampleSum;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSum {

    private static long sum = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static synchronized void add(int val)
    {
        sum += val;
    }

    static class FirstHalf implements Runnable
    {
        @Override
        public void run() {
            // first option: with locks
//            lock.lock();
//            for (int i = 1; i < 500000; i++) {
//                sum += i;
//            }
//            lock.unlock();

            // second option: synchronized function
            for (int i = 1; i < 500000; i++)
                add(i);
        }
    }

    static class SecondHalf implements Runnable
    {
        @Override
        public void run() {
//            lock.lock();
//            for (int i = 500000; i <= 1000000; i++) {
//                sum += i;
//            }
//            lock.unlock();

            for (int i = 500000; i <= 1000000; i++)
                add(i);
        }
    }

    public static void main(String[] args) {
        // one thread
//        long start = System.currentTimeMillis();
//        long sum = 0;
//        for (int i = 1; i <= 1000000; i++)
//            sum += i;
//        long end = System.currentTimeMillis();
//        System.out.println("Running time: " + (end - start));
//        System.out.println("Sum is: " + sum);

        // two threads
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(new FirstHalf(), "First");
        Thread t2 = new Thread(new SecondHalf(), "Second");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();

        System.out.println("Running time: " + (end - start));
        System.out.println("Sum is: " + sum);
    }
}
