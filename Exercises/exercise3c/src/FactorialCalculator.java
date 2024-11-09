import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
