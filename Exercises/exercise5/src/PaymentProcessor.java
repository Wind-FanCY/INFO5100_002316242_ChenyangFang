// Structural Patterns - Adapter Pattern
class PaymentProcessor {
    public void processCashPayment(double amount) {
        String formatted = String.format("%.2f", amount);
        System.out.println("Cash payment：" + formatted + " dollars");
    }

    public void processCreditCardPayment(double amount) {
        String formatted = String.format("%.2f", amount);
        System.out.println("Credit payment：" + formatted + " dollars");
    }
}