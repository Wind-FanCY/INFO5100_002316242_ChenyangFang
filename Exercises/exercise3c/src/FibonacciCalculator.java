import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
