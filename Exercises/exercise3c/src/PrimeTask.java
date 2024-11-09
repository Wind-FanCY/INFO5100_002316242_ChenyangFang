import java.text.SimpleDateFormat;
import java.util.Date;

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
