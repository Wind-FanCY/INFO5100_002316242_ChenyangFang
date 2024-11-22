import java.util.*;

// Bookstore Management
class Bookstore {
    private List<BookBase> books;
    private PaymentProcessor paymentProcessor;
    private DiscountStrategy discountStrategy;

    public Bookstore() {
        this.books = new ArrayList<>();
        this.paymentProcessor = new PaymentProcessor();
        this.discountStrategy = new MemberDiscount();
    }

    public void addBook(BookBase book) {
        books.add(book);
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public void purchaseBook(BookBase book, boolean useCreditCard) {
        book.display();
        double discountedPrice = discountStrategy.calculateDiscount(book.getPrice());

        if (useCreditCard) {
            paymentProcessor.processCreditCardPayment(discountedPrice);
        } else {
            paymentProcessor.processCashPayment(discountedPrice);
        }
    }
}

// Main
public class MainProgram {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();

        BookBase novel1 = new NovelBook("Harry Potter and the Half-Blood Prince", 29.9, "J.K. Rowling");
        BookBase novel2 = new NovelBook("1984", 19.99, "George Orwell");
        BookBase textbook1 = new TextBook("Calculus: Early Transcendentals", 69.9, "Math");
        BookBase textbook2 = new TextBook("Computer Science", 59.99, "Programming");

        bookstore.addBook(novel1);
        bookstore.addBook(novel2);
        bookstore.addBook(textbook1);
        bookstore.addBook(textbook2);

        System.out.println("Scene1：Novel- MemberDiscount - Cash");
        bookstore.purchaseBook(novel1, false);

        System.out.println("\nScene2：Novel - MemberDiscount - Credit");
        bookstore.setDiscountStrategy(new MemberDiscount());
        bookstore.purchaseBook(novel2, true);

        System.out.println("\nScene3：TextBook - SeasonalDiscount - Cash");
        bookstore.setDiscountStrategy(new SeasonalDiscount());
        bookstore.purchaseBook(textbook1, false);

        System.out.println("\nScene4：TextBook - SeasonalDiscount -Credit");
        bookstore.setDiscountStrategy(new SeasonalDiscount());
        bookstore.purchaseBook(textbook2, true);
    }
}