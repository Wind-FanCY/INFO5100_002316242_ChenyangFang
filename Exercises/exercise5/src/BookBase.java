// Creation Patterns - Factory Method Pattern
abstract class BookBase {
    protected String title;
    protected double price;

    public BookBase(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public abstract void display();

    public double getPrice() {
        return price;
    }
}

class NovelBook extends BookBase {
    private String author;

    public NovelBook(String title, double price, String author) {
        super(title, price);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Novel Book: " + title + " (Author: " + author + ")");
    }
}

class TextBook extends BookBase {
    private String subject;

    public TextBook(String title, double price, String subject) {
        super(title, price);
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("Text Book: " + title + " (Subject: " + subject + ")");
    }
}