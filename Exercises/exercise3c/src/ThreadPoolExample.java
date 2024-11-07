import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrimeTask implements Runnable {
    private int number;

    PrimeTask(int number) {
        this.number = number;
    }

    public void run() {
        int prime = calculatePrime(number);
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date(timeStamp);
        String formattedTime = sdf.format(time);
        System.out.printf("[%s] Thread: #%s, Prime #%d is %d%n", formattedTime, Thread.currentThread().getName(), number, prime);
    }

    private int calculatePrime(int n) {
        int count = 0, num = 2;
        while (count < n) {
            if (isPrime(num)) {
                count++;
            }
            num++;
        }
        return num - 1;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

class FibonacciTask implements Runnable {
    private int number;

    FibonacciTask(int number) {
        this.number = number;
    }

    public void run() {
        long fibonacci = calculateFibonacci(number);
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date(timeStamp);
        String formattedTime = sdf.format(time);
        System.out.printf("[%s] Thread: #%s, Fibonacci #%d is %d%n", formattedTime, Thread.currentThread().getName(), number, fibonacci);
    }

    private long calculateFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}

class FactorialTask implements Runnable {
    private int number;

    FactorialTask(int number) {
        this.number = number;
    }

    public void run() {
        BigInteger factorial = factorial(number);
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date(timeStamp);
        String formattedTime = sdf.format(time);
        System.out.printf("[%s] Thread: #%s, Factorial of #%d is %d%n", formattedTime, Thread.currentThread().getName(), number, factorial);
    }

    private BigInteger factorial(int n) {
        if (n == 0) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

public class ThreadPoolExample {
    public static void main(final String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Prime tasks
        for (int i = 1; i <= 25; i++) {
            executor.submit(new PrimeTask(i));
            sleepRandom();
        }

        // Fibonacci tasks
        for (int i = 0; i < 50; i++) {
            executor.submit(new FibonacciTask(i));
            sleepRandom();
        }

        // Factorial tasks
        for (int i = 0; i <= 50; i++) {
            executor.submit(new FactorialTask(i));
            sleepRandom();
        }

        executor.shutdown();
    }

    private static void sleepRandom() {
        try {
            Thread.sleep(new Random().nextInt(401) + 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
