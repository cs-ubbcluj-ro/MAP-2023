package com.example.seminar6;

public class Util {

    public static boolean isPrime(int x) {
        if (x == 2) {
            return true;
        }

        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimes(int[] numbers, int startIndex, int step) {
        int total = 0;
        int index = startIndex;//step = 3

        while (index < numbers.length) {
            if (isPrime(numbers[index])) {
                total += 1;
            }
            index += step;
        }
        return total;
    }

    public static int[] generate(int n) {
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = (int) (Math.random() * 1000000);
//            System.out.println(numbers[i]);
        }
//        System.out.println("done");
        return numbers;
    }
}
