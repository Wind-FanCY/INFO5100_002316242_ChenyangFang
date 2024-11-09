import java.text.SimpleDateFormat;
import java.util.Date;

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
