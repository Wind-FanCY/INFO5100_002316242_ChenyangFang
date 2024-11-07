import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

class PrimeCalculator extends Thread {
    private Thread t;
    private int count;
    private String threadName;

    PrimeCalculator(int count, String threadName) {
        this.count = count;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int primeCount = 0, num = 2;
        while (primeCount < count) {
            if (isPrime(num)) {
                primeCount++;
                long timeStamp = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date time = new Date(timeStamp);
                String formattedTime = sdf.format(time);
                System.out.printf("[%s] Thread: #%s, Prime #%d is %d%n", formattedTime, threadName, primeCount, num);
                randomDelay();
            }
            num++;
        }
        System.out.println((threadName + " end"));
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void randomDelay() {
        try {
            Thread.sleep(new Random().nextInt(401) + 100); // Random delay between 100-500 ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void start() {
        System.out.println(threadName + " starting");
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class FibonacciCalculator extends Thread {
    private Thread t;
    private int count;
    private String threadName;

    FibonacciCalculator(int count, String threadName) {
        this.count = count;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        long a = 0, b = 1;
        for (int i = 1; i <= count; i++) {
            long timeStamp = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date(timeStamp);
            String formattedTime = sdf.format(time);
            System.out.printf("[%s] Thread: #%s, Fibonacci #%d is %d%n", formattedTime, threadName, i, a);
            long next = a + b;
            a = b;
            b = next;
            randomDelay();
        }
        System.out.println((threadName + " end"));
    }

    private void randomDelay() {
        try {
            Thread.sleep(new Random().nextInt(401) + 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void start() {
        System.out.println(threadName + " starting");
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class FactorialCalculator extends Thread {
    private Thread t;
    private int count;
    private String threadName;

    FactorialCalculator(int count, String threadName) {
        this.count = count;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i <= count; i++) {
            long timeStamp = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date time = new Date(timeStamp);
            String formattedTime = sdf.format(time);
            System.out.printf("[%s] Thread: #%s, Factorial of #%d is %d%n", formattedTime, threadName, i, factorial(i));
            randomDelay();
        }
        System.out.println((threadName + " end"));
    }

    private BigInteger factorial(int n) {
        if (n == 0) return BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private void randomDelay() {
        try {
            Thread.sleep(new Random().nextInt(401) + 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void start() {
        System.out.println(threadName + " starting");
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        Thread primeThread = new PrimeCalculator(25, "Thread-01");
        Thread fibonacciThread = new FibonacciCalculator(50, "Thread-02");
        Thread factorialThread = new FactorialCalculator(50, "Thread-03");

        primeThread.start();
        fibonacciThread.start();
        factorialThread.start();
    }
}
