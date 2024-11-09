import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PartBMain{
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
