public class PartAMain {
    public static void main(String[] args) {
        Thread primeThread = new PrimeCalculator(25, "Thread-01");
        Thread fibonacciThread = new FibonacciCalculator(50, "Thread-02");
        Thread factorialThread = new FactorialCalculator(50, "Thread-03");

        primeThread.start();
        fibonacciThread.start();
        factorialThread.start();
    }
}
