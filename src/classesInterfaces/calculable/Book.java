package classesInterfaces.calculable;

public class Book implements Calculable {
    private final String title;
    private final String author;
    private double price;
    private double discount;

    public Book(String title, String author, double price, double discount) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.discount = discount;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public double calculateFinalPrice() {
        return price - (price * discount);
    }
}
