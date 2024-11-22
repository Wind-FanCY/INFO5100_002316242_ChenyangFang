// Behavioral Patterns - Strategy Pattern
interface DiscountStrategy {
    double calculateDiscount(double originalPrice);
}

class MemberDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        return originalPrice * 0.9;
    }
}

class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double originalPrice) {
        return originalPrice * 0.8;
    }
}