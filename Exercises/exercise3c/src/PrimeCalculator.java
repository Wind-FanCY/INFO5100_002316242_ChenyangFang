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
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
