import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

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
