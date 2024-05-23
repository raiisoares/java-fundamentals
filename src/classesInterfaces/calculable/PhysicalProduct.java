package classesInterfaces.calculable;

public class PhysicalProduct implements Calculable {
    private final String productName;
    private final String description;
    private double price;
    private double tax;
    private double shippingCost;

    public PhysicalProduct(String productName, String description, double price, double tax, double shippingCost) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.tax = tax;
        this.shippingCost = shippingCost;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public double calculateFinalPrice() {
        return price + (price * tax) + shippingCost;
    }
}
